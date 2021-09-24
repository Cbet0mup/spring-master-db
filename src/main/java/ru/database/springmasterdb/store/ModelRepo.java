package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<ModelName, Integer> {
}
