package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.Status;

public interface StatusRepo extends JpaRepository<Status, Long> {
}
