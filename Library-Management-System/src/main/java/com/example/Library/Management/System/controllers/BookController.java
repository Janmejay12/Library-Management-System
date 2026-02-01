package com.example.Library.Management.System.controllers;

import com.example.Library.Management.System.dtos.BookRequestDto;
import com.example.Library.Management.System.dtos.BookResponseDto;
import com.example.Library.Management.System.entities.Book;
import com.example.Library.Management.System.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping

    public ResponseEntity<BookResponseDto> createBook(@Valid @RequestBody BookRequestDto dto){
        return ResponseEntity.ok(bookService.createBook(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> findBookByAuthorName(@RequestParam  String authorName){
        return ResponseEntity.ok(bookService.findBookByAuthorName(authorName));
    }

    @GetMapping("/lib")
    public ResponseEntity<List<Book>> findAllBookWithLibrary(@RequestParam  String LibraryName ){
        return ResponseEntity.ok(bookService.findAllBookWithLibrary(LibraryName));
    }
}
