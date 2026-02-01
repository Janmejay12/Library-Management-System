package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dtos.CreateAuthorRequest;
import com.example.Library.Management.System.entities.Author;
import com.example.Library.Management.System.repos.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(CreateAuthorRequest request){

        Author author = new Author();
        author.setAuthorName(request.getAuthorName());
        author.setBiography(request.getBiography());
        author.setBooks(request.getBooks());
        authorRepository.save(author);
        return author;

    }
}
