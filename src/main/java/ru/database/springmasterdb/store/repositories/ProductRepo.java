package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
