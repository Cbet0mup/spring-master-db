package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAll();
}
