package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dtos.BookRequestDto;
import com.example.Library.Management.System.dtos.BookResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    BookResponseDto create(BookRequestDto dto);

    BookResponseDto getById(Long id);

    BookResponseDto update(Long id, BookRequestDto dto);

    void delete(Long id);

    Page<BookResponseDto> getAll(int page, int size, String sortBy);

    List<BookResponseDto> search(String title, Integer year, String library);

    List<BookResponseDto> byAuthor(String name);

    List<BookResponseDto> byTitleNative(String title);
}
