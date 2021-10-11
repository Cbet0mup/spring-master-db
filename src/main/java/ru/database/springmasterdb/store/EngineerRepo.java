package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EngineerRepo extends JpaRepository<Engineer, Integer> {

    @Query("FROM Engineer")
    List<Engineer> getAll();
}
