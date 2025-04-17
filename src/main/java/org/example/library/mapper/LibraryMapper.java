package org.example.library.mapper;

import org.example.library.dto.LibraryDto;
import org.example.library.entity.LibraryEntity;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {
    public LibraryDto entityToDto(LibraryEntity service) {
        return new LibraryDto(service.getId(), service.getName(), service.getVersion(), service.getDescription(), service.getType(), service.getCategory(), service.getChecksum(), service.getStatus(), service.getAuthor(), service.getSize(), service.getCreateAt(), service.getUpdateAt());
    }

    public LibraryEntity dtoToEntity(LibraryDto libraryDto) {
        return new LibraryEntity(libraryDto.getId(), libraryDto.getName(), libraryDto.getVersion(), libraryDto.getDescription(), libraryDto.getType(), libraryDto.getCategory(), libraryDto.getChecksum(), libraryDto.getStatus(), libraryDto.getAuthor(), libraryDto.getSize(), libraryDto.getCreateAt(), libraryDto.getUpdateAt());
    }
}
