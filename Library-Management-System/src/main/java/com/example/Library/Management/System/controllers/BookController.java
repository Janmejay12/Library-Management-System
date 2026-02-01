package com.example.Library.Management.System.controllers;

import com.example.Library.Management.System.dtos.BookRequestDto;
import com.example.Library.Management.System.dtos.BookResponseDto;
import com.example.Library.Management.System.services.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    /* CREATE */
    @PostMapping
    public ResponseEntity<BookResponseDto> create(
            @Valid @RequestBody BookRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    /* GET BY ID */
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    /* UPDATE */
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    /* DELETE */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* PAGINATION */
    @GetMapping
    public ResponseEntity<Page<BookResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "bookTitle") String sort) {
        return ResponseEntity.ok(service.getAll(page, size, sort));
    }

    /* CRITERIA API - Dynamic Search */
    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDto>> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String library) {
        return ResponseEntity.ok(service.search(title, year, library));
    }

    /* JPQL - By Author Name */
    @GetMapping("/author/{name}")
    public ResponseEntity<List<BookResponseDto>> byAuthor(@PathVariable String name) {
        return ResponseEntity.ok(service.byAuthor(name));
    }

    /* NATIVE - By Title */
    @GetMapping("/native/title/{title}")
    public ResponseEntity<List<BookResponseDto>> byTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.byTitleNative(title));
    }
}
