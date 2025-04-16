package org.example.library.unit;

import org.example.library.entity.LibraryEntity;
import org.example.library.util.LibraryStatus;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LibraryEntityTests {

    @Test
    public void libraryAllArgs() {
        LibraryEntity libraryEntity = new LibraryEntity(
                UUID.fromString("6f011b14-44b7-45f7-8e48-7d5db12e9f7a"),
                "Library Name",
                "Library Address",
                "Library Phone",
                LibraryStatus.ACTIVE,
                LocalDate.now(),
                LocalDate.now(),
                "Library Phone",
                "Library Phone",
                1
        );

        assertNotNull(libraryEntity.getId());
        assertNotNull(libraryEntity.getName());
        assertNotNull(libraryEntity.getDescription());
        assertNotNull(libraryEntity.getVersion());
        assertNotNull(libraryEntity.getStatus());
        assertNotNull(libraryEntity.getCreateAt());
        assertNotNull(libraryEntity.getUpdateAt());
        assertNotNull(libraryEntity.getAuthor());
        assertNotNull(libraryEntity.getUrl());
        assertNotNull(libraryEntity.getSize());
    }

    @Test
    public void libraryNoArgs() {
        LibraryEntity libraryEntity = new LibraryEntity();

        assertNull(libraryEntity.getId());
        assertNull(libraryEntity.getName());
        assertNull(libraryEntity.getDescription());
        assertNull(libraryEntity.getVersion());
        assertNull(libraryEntity.getStatus());
        assertNull(libraryEntity.getCreateAt());
        assertNull(libraryEntity.getUpdateAt());
        assertNull(libraryEntity.getAuthor());
        assertNull(libraryEntity.getUrl());
        assertNull(libraryEntity.getSize());
    }


}
