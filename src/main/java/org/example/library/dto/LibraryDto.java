package org.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.library.util.LibraryStatus;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
    private UUID id;

    private String name;

    private String description;

    private String version;

    private LibraryStatus status;

    private String author;

    private String url;

    private Integer size;
}
