package com.example.Library.Management.System.repos;

import com.example.Library.Management.System.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    /* ---------------- JPQL Queries ---------------- */

    // 1. By author name
    @Query("""
                SELECT b FROM Book b
                JOIN b.authors a
                WHERE a.authorName = :name
            """)
    List<Book> findByAuthorName(@Param("name") String name);

    // 2. By library name
    @Query("""
                SELECT b FROM Book b
                WHERE b.library.libraryName = :lib
            """)
    List<Book> findByLibraryName(@Param("lib") String lib);

    /* ---------------- Native Queries ---------------- */

    // 3. By title (native)
    @Query(value = "SELECT * FROM book WHERE book_title = :title", nativeQuery = true)
    List<Book> findByTitleNative(@Param("title") String title);

    // 4. Join native - books by library name
    @Query(value = """
                SELECT b.*
                FROM book b
                JOIN library l ON b.library_id = l.library_id
                WHERE l.library_name = :name
            """, nativeQuery = true)
    List<Book> findByLibraryNative(@Param("name") String name);
}
