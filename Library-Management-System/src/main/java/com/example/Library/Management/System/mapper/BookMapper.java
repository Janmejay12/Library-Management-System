package com.example.Library.Management.System.mapper;

import com.example.Library.Management.System.dtos.BookRequestDto;
import com.example.Library.Management.System.dtos.BookResponseDto;
import com.example.Library.Management.System.entities.Author;
import com.example.Library.Management.System.entities.Book;
import com.example.Library.Management.System.entities.Library;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {
    public static Book toEntity(BookRequestDto bookRequest, Library library, List<Author> authors) {
        Book book = new Book();
        book.setBookTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setPublicationYear(bookRequest.getPublicationYear());
        book.setLibrary(library);
        List<Author> authorsList = authors;
        book.setAuthors(authorsList);
        return book;
    }


    public static BookResponseDto toDto(Book book) {
        BookResponseDto response = new BookResponseDto();
        response.setBookId(book.getBookId());
        response.setBookTitle(book.getBookTitle());
        response.setIsbn(book.getIsbn());
        response.setPublicationYear(book.getPublicationYear());
        response.setLibraryName(book.getLibrary().getLibraryName()); // Assuming Library has getName()

        response.setAuthors(
                book.getAuthors()
                        .stream()
                        .map(Author::getAuthorName)
                        .collect(Collectors.toSet())
        );


        return response;
    }}
