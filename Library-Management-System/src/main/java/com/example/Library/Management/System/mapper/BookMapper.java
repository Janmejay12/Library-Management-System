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
        book.setAuthors(authors);
        return book;
    }

    public static Book toEntity(BookRequestDto bookRequest, List<Author> authors) {
        Book book = new Book();
        book.setBookTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setPublicationYear(bookRequest.getPublicationYear());
        book.setAuthors(authors);
        return book;
    }

    public static BookResponseDto toDto(Book book) {
        BookResponseDto response = new BookResponseDto();
        response.setBookId(book.getBookId());
        response.setBookTitle(book.getBookTitle());
        response.setIsbn(book.getIsbn());
        response.setPublicationYear(book.getPublicationYear());

        // Set library name
        if (book.getLibrary() != null) {
            response.setLibraryName(book.getLibrary().getLibraryName());
        }

        // Set authors
        response.setAuthors(
                book.getAuthors()
                        .stream()
                        .map(Author::getAuthorName)
                        .collect(Collectors.toSet()));

        return response;
    }
}
