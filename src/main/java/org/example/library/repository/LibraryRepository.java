package org.example.library.repository;

import org.example.library.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LibraryRepository extends JpaRepository<LibraryEntity, UUID> {
}
