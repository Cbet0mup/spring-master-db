package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.Engineer;

public interface EngineerRepo extends JpaRepository<Engineer, Long> {
}
