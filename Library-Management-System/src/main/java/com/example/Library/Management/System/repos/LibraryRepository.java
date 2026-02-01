package com.example.Library.Management.System.repos;

import com.example.Library.Management.System.entities.Author;
import com.example.Library.Management.System.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    @Query("SELECT a FROM Author a WHERE a.name = :name")
    List<Library> searchByName(@Param("name") String name);
}
