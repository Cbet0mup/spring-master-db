package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepo extends JpaRepository<Price, Integer> {
    List<Price> findAllByProductId(Integer id);
}
