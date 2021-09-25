package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.Engineer;

public interface EngineerRepo extends JpaRepository<Engineer, Integer> {
}
