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

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private String version;

    @Column(name = "path")
    private String path;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "category")
    private String category;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "checksum")
    private String checksum;

    @Column(name = "status")
    private LibraryStatus status;

    @Column(name = "author")
    private String author;

    @Column(name = "size")
    private long size;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "update_at", nullable = true)
    private LocalDate updateAt;

    public LibraryEntity(UUID id, String name, String version, String description, String type, String category, String checksum, LibraryStatus status, String author, long size, LocalDate createAt, LocalDate updateAt) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.type = type;
        this.category = category;
        this.checksum = checksum;
        this.status = status;
        this.author = author;
        this.size = size;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
