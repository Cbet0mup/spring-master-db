package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.Status;

public interface StatusRepo extends JpaRepository<Status, Long> {
}
