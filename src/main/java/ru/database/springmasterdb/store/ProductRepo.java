package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
