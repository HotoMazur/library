package org.example.library.service;

import org.example.library.entity.LibraryEntity;
import org.example.library.repository.LibraryRepository;
import org.example.library.util.LibraryStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${file.upload-dir}")
    private static final String UPLOAD_DIR = "";


    public LibraryService(LibraryRepository libraryRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.libraryRepository = libraryRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public LibraryEntity getServiceById(UUID id) {
        return libraryRepository.findById(id).orElse(null);
    }

    public List<LibraryEntity> getAllServices() {
        return libraryRepository.findAll();
    }

    public void deleteServiceById(UUID id) {
        LibraryEntity libraryEntity = libraryRepository.findById(id).orElse(null);
        if (libraryEntity == null) {
            throw new IllegalArgumentException("Library with id " + id + " not found");
        }
        libraryEntity.setStatus(LibraryStatus.DELETED);
        libraryRepository.save(libraryEntity);
    }

    public ResponseEntity<String> addService(MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            kafkaTemplate.send("services-add-topic", filePath.toString());

            return ResponseEntity.ok("File uploaded successfully: " + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
