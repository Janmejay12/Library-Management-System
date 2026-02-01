package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dtos.AuthorRequestDto;
import com.example.Library.Management.System.dtos.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    AuthorResponseDto create(AuthorRequestDto dto);

    AuthorResponseDto getById(Long id);

    AuthorResponseDto update(Long id, AuthorRequestDto dto);

    void delete(Long id);

    List<AuthorResponseDto> getAll();

    AuthorResponseDto findByName(String name);
}
