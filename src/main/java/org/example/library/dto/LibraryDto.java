package org.example.library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.library.util.LibraryStatus;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
    private UUID id;

    private String name;

    private String version;

    private String description;

    private String type;

    private UUID category_id;

    private String checksum;

    private LibraryStatus status;

    private String author;

    private long size;

    private LocalDate createAt;

    private LocalDate updateAt;
}
