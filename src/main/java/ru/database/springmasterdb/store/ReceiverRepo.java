package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.Receiver;

public interface ReceiverRepo extends JpaRepository<Receiver, Long> {
}
