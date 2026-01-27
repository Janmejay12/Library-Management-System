package com.example.Library.Management.System.dtos;

import com.example.Library.Management.System.entities.Library;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BookResponseDto {
    private Long bookId;
    private String bookTitle;
    private String isbn;
    private Year publicationYear;
    private String libraryName;
    private Set<String> authors;

}
