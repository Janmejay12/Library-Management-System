package com.example.Library.Management.System.repos;

import com.example.Library.Management.System.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
    SELECT b FROM Book b
    JOIN b.authors a
    WHERE a.authorName = :authorName
""")

    List<Book> findBookByAuthorName(@Param( "authorName") String authorName);

    @Query(
            """
        SELECT b FROM Book b 
        WHERE b.Library.name = :lib
"""
    )
    List<Book> findByLibraryName (@Param("lib") String lib);


    @Query(
            value = """
    SELECT b.*
    FROM book b
    JOIN library l ON b.library_id = l.id
    WHERE l.name = :name;
""",
            nativeQuery = true
    )

    List<Book> findAllBookWithLibrary(@Param("name") String name);

    @Query(
            value = "SELECT * FROM book WHERE title = :title",
            nativeQuery = true
    )
    List<Book> findByTitle(@Param("title") String title);













}
