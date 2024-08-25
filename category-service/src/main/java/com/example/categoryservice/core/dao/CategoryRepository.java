package com.example.categoryservice.core.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"category"})
    @Query(value = "update Category c set c.name = :name where c.id = :id")
    Category updateById(@NotNull Integer id,
                        @NotBlank String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_books.category, library_books.book"})
    @Query(value = "select b from Book b join Category c on b.category.id = c.id where lower(c.name) = lower(:name)")
    Category findAllByCategoryName(@NotBlank String name);

    //TODO: При удалении категории удалять книги или просто убирать записи из колонки "category_id"(сейчас 2й вариант)
    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_books.category, library_books.book"})
    @Query("delete from Category с where с.id = :id")
    void deleteById(@NotNull Integer id);

}
