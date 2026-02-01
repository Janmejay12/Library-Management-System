package com.example.Library.Management.System.controllers;

import com.example.Library.Management.System.dtos.CreateAuthorRequest;
import com.example.Library.Management.System.entities.Author;
import com.example.Library.Management.System.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author createAuthor(@RequestBody CreateAuthorRequest request){
       return authorService.createAuthor(request);
    }
}
