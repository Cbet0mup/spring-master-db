package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelRepo extends JpaRepository<ModelName, Integer> {
    @Query("FROM ModelName")
    List<ModelName> getAll();
    List<ModelName> findAllByManufacturerId(Integer id);


}
