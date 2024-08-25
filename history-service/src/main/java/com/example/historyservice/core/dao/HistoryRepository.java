package com.example.historyservice.core.dao;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"history"})
    @Query(nativeQuery = true,
            value = "insert into library_users.history (id, customer_id, book_id, status, created_at, updated_at) " +
                    "values (history.id, :customerId, :bookId, 'received', current_timestamp, null);")
    History saveHistory(@NotNull Integer customerId,
                        @NotNull Integer bookId);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.history"})
    @Query(nativeQuery = true,
            value = "update library_users.history h set h.status = 'returned', h.updatedAt = current_timestamp where h.customer.id = :customerId and h.book.id = :bookId")
    History updateHistory(@NotNull Integer customerId,
                          @NotNull Integer bookId);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.history", "library_users.user"})
    @Query(nativeQuery = true,
            value = "select h.status from library_users.history h where h.book_id = :bookId order by id desc limit 1;")
    String checkBookStatusById(@NotNull Integer bookId);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.history"})
    @Query(nativeQuery = true,
            value = "select h.book_id from library_users.history h where h.customer_id = :customerId and lower(h.status) = :status;")
    List<Integer> getReportByCustomerId(@NotNull Integer customerId, String status);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.history", "library_users.user"})
    @Query(nativeQuery = true,
            value = "select h.book_id from library_users.history h where h.customer_id = (select u.customer_id from library_users.user u where u.id = :userId) and lower(h.status) = :status;")
    List<Integer> getReportByUserId(@NotNull Integer userId, String status);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.history"})
    @Query(nativeQuery = true,
            value = "delete from library_users.history h where h.id = :id")
    void deleteById(@NotNull Integer id);
}
