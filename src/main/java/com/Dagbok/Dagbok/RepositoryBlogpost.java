package com.Dagbok.Dagbok;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBlogpost extends CrudRepository<Blogpost, Integer> {

    @Query("SELECT b FROM Blogpost b WHERE b.date <= :today") // lista utan framtida inlägg
    List<Blogpost> notFutureDate(@Param("today") LocalDate today);

    @Query("SELECT b FROM Blogpost b WHERE b.date BETWEEN :from AND :to") // lista med inlägg mellan två datum
    List<Blogpost> filteredDates(@Param("from") LocalDate from, @Param("to") LocalDate to);

}
