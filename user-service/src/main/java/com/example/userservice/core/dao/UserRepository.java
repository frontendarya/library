package com.example.userservice.core.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.users"})
    @Query(nativeQuery = true,
            value = """
insert into library_users.users (id, username, password, customer_id, role) 
values (, :username, :password, :customerId, :role);
""")
    User save(@NotBlank String username,
              @NotBlank String password,
              Integer customerId,
              String role);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.users"})
    @Query(nativeQuery = true,
            value = """
update library_users.users u
set
    u.username = case
                   when :username is not null then :username
                   else u.username
        end,
    u.password = case
                    when :password is not null then :password
                    else u.password
        end,
    u.customer.id = case
                     when :customerId is not null then :customerId
                     else u.customer.id
        end,
    u.role = case
                     when :role is not null then :role
                     else u.role
        end
where u.id = :userId
""")
    User updateById(@NotNull Integer userId,
                    String username,
                    String password,
                    Integer customerId,
                    String role);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.users"})
    @Query(nativeQuery = true,
            value = "update library_users.users u set u.role = :role where u.id = :userId")
    User insertUserRole(Integer userId, String role);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"library_users.users"})
    @Query(nativeQuery = true,
            value = "delete from library_users.users u where u.id = :userId")
    void deleteById(Integer userId);
}
