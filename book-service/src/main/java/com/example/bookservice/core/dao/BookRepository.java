package com.example.bookservice.core.dao;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"book"})
    @Query(value = "select b from Book b where lower(b.title) like concat('%', :title, '%')")
    List<Book> findByTittle(@NotBlank String title);

    //@EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"category", "authors"})
    @Query("select b from Book b join fetch b.authors, b.category where b.id = :id")
    Book getDetailsById(@Param("id") Integer id);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"book"})
    @Query("delete from Book b where b.id = :id")
    void deleteById(@Param("id") Integer id);

}
