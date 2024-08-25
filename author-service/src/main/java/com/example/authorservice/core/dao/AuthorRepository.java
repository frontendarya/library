package com.example.authorservice.core.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD)
    @Query("""
update Author a
set
    a.lastname = case
                   when :lastname is not null then :lastname
                   else a.lastname
        end,
    a.firstname = case
                    when :firstname is not null then :firstname
                    else a.firstname
        end,
    a.middlename = case
                     when :middlename is not null then :middlename
                     else a.middlename
        end,
    a.isNative = case
                     when :isNative is not null then :isNative
                     else a.isNative
        end
where a.id = :id
""")
    Author updateById(@NotNull Integer id,
                      String lastname,
                      String firstname,
                      String middlename,
                      Boolean isNative);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_books.book", "library_books.author_book"})
    @Query(nativeQuery = true, value = """
select * from library_books.book b where b.id in (select ab.book_id from library_books.author_book ab where ab.author_id = 1);
""")
    Author findAllBooksByAuthorId(@NotNull Integer id);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"author"})
    @Query(nativeQuery = true,
            value = """
select *
from library_books.book b
    join library_books.author_book ab on b.id = ab.book_id
    join library_books.author a on ab.author_id = a.id
where (a.is_native = :isNative or null) and lower(a.firstname) = :firstname and lower(a.lastname) = :lastname and (lower(a.middlename) = :middlename or a.middlename is null);
""")
    Author findAllBooksByAuthorFio(@NotBlank String lastname,
                                   @NotBlank String firstname,
                                   String middlename,
                                   Boolean isNative);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"author"})
    @Query("delete from Author a where a.id = :id")
    void deleteById(@NotNull Integer id);
}
