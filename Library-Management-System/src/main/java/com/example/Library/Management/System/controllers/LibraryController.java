package com.example.Library.Management.System.controllers;

import com.example.Library.Management.System.dtos.LibraryRequestDto;
import com.example.Library.Management.System.dtos.LibraryResponseDto;
import com.example.Library.Management.System.services.LibraryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LibraryResponseDto> create(@Valid @RequestBody LibraryRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody LibraryRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LibraryResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<LibraryResponseDto>> searchByName(
            @RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }
}
