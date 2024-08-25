package com.example.customerservice.core.dao;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"customer"})
    @Query("""
update Customer c
set
    c.lastname = case
                   when :lastname is not null then :lastname
                   else c.lastname
        end,
    c.firstname = case
                    when :firstname is not null then :firstname
                    else c.firstname
        end,
    c.middlename = case
                     when :middlename is not null then :middlename
                     else c.middlename
        end
where c.id = :id
""")
    Customer updateById(@NotNull Integer id,
                        String firstname,
                        String lastname,
                        String middlename);

    @Modifying
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"customer", "user"})
    @Query(nativeQuery = true, value = """
delete from library_users.customer с where с.id = :id;
delete from library_users.user u where u.customer_id = :id;
""")
    void deleteById(@NotNull Integer id);
}
