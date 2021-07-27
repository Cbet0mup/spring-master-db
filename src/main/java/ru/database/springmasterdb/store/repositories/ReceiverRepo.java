package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.Receiver;

public interface ReceiverRepo extends JpaRepository<Receiver, Long> {
}
