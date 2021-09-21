package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("FROM Product")
    List<Product> getAll();
}
