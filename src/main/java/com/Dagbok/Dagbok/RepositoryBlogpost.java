package com.Dagbok.Dagbok;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBlogpost extends CrudRepository<Blogpost, Integer> {
    // filtrerar bort framtida inlägg
    @Query("SELECT b FROM Blogpost b WHERE b.date <= :today")
    List<Blogpost> notFutureDate(@Param("today") LocalDate today);

    @Query("SELECT b FROM Blogpost b WHERE b.date BETWEEN :from AND :to")
    List<Blogpost> filteredDates(@Param("from") LocalDate from, @Param("to") LocalDate to);

}
