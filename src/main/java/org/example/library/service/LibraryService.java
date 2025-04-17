package org.example.library.service;

import org.example.library.entity.LibraryEntity;
import org.example.library.repository.LibraryRepository;
import org.example.library.util.LibraryStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    private final KafkaTemplate<String, LibraryEntity> kafkaTemplate;


    public LibraryService(LibraryRepository libraryRepository, KafkaTemplate<String, LibraryEntity> kafkaTemplate) {
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

    public void addService(LibraryEntity libraryEntity) {
        kafkaTemplate.send("service-add-topic", libraryEntity);
    }
}
