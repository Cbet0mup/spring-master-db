package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.TestEntity;

public interface TestRepo extends JpaRepository<TestEntity, Long> {
}
