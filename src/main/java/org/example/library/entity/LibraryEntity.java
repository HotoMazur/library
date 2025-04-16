package org.example.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.library.util.LibraryStatus;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "library")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "status", nullable = false)
    private LibraryStatus status;

    @Column(name = "create_at", nullable = false)
    private LocalDate createAt;

    @Column(name = "update_at", nullable = true)
    private LocalDate updateAt;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "size", nullable = false)
    private Integer size;
}
