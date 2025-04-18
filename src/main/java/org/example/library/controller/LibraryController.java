package org.example.library.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.java.Log;
import org.example.library.dto.LibraryDto;
import org.example.library.mapper.LibraryMapper;
import org.example.library.service.LibraryService;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/services")
@Log
public class LibraryController {
    private final LibraryService service;
    private final LibraryMapper mapper;

    public LibraryController(LibraryService service, LibraryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RouterOperation(operation = @Operation(description = "Get service", operationId = "getService", tags = "service",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = LibraryDto.class)))))
    @GetMapping("/{id}")
    public LibraryDto getServiceById(@PathVariable UUID id) {
        return mapper.entityToDto(service.getServiceById(id));
    }

    @RouterOperation(operation = @Operation(description = "Get list of services", operationId = "getServices", tags = "service",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = List.class, type = "array", subTypes = LibraryDto.class)))))
    @GetMapping
    public List<LibraryDto> getAllServices() {
        return service.getAllServices().stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @RouterOperation(operation = @Operation(description = "Delete service", operationId = "delete", tags = "service",
            responses = @ApiResponse(responseCode = "200")))
    @DeleteMapping("/{id}")
    public void deleteServiceById(@PathVariable UUID id) {
        service.deleteServiceById(id);
    }


    @PostMapping
    public ResponseEntity<String> addService(@RequestParam("file")MultipartFile file) {
        return service.addService(file);
    }
}
