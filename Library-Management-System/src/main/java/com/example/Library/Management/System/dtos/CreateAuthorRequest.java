package com.example.Library.Management.System.dtos;

import com.example.Library.Management.System.entities.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateAuthorRequest {
    private String authorName;
    private String biography;
    List<Book> books = new ArrayList<>();
}
