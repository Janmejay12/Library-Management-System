package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dtos.BookRequestDto;
import com.example.Library.Management.System.dtos.BookResponseDto;
import com.example.Library.Management.System.entities.Author;
import com.example.Library.Management.System.entities.Book;
import com.example.Library.Management.System.entities.Library;
import com.example.Library.Management.System.mapper.BookMapper;
import com.example.Library.Management.System.repos.AuthorRepository;
import com.example.Library.Management.System.repos.BookRepository;
import com.example.Library.Management.System.repos.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, LibraryRepository libraryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
        this.authorRepository = authorRepository;
    }

    public BookResponseDto createBook(BookRequestDto dto){
        //Library library = libraryRepository.findById(dto.getLibraryId()).orElseThrow(() -> new RuntimeException("Library not found"));

        List<Author> authors = authorRepository.findAllById(dto.getAuthorIds());
                //.stream().collect(Collectors.toSet());

        Book book = BookMapper.toEntity(dto, authors);
        Book saved = bookRepository.save(book);

        return BookMapper.toDto(saved);
    }

    public List<Book>  findBookByAuthorName(String name){

        return bookRepository.findBookByAuthorName(name);
    }

    public List<Book> findAllBookWithLibrary(String name){
        return bookRepository.findAllBookWithLibrary(name);
    }

}
