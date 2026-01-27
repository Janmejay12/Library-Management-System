package com.example.Library.Management.System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libraryId;
    private String libraryName;
    private String location;

    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

}
