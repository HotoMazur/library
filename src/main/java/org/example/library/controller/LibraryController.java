package org.example.library.controller;

import org.example.library.dto.LibraryDto;
import org.example.library.mapper.LibraryMapper;
import org.example.library.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController(value = "/api/v1/servcies")
public class LibraryController {
    private final LibraryService service;
    private final LibraryMapper mapper;

    public LibraryController(LibraryService service, LibraryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public LibraryDto getServiceById(UUID id) {
        return mapper.entityToDto(service.getServiceById(id));
    }

    @GetMapping("/")
    public List<LibraryDto> getAllServices() {
        return service.getAllServices().stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void deleteServiceById(UUID id) {
        service.deleteServiceById(id);
    }

    @PostMapping("/")
    public void addService(@RequestBody LibraryDto libraryDto) {
        service.addService(mapper.dtoToEntity(libraryDto));
    }
}
