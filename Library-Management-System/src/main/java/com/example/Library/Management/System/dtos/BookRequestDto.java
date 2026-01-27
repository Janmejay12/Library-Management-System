package com.example.Library.Management.System.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.List;

@Getter
@Setter
public class BookRequestDto {
    @NotBlank
    @Size(min = 2, max = 200)
    private String title;

    @NotBlank
    private String isbn;

    @NotNull
    private Year publicationYear;

    @NotNull
    private Long libraryId;

    private List<Long> authorIds;


}
