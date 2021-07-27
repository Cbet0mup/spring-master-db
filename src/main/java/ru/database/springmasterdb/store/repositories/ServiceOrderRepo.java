package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.ServiceOrder;

public interface ServiceOrderRepo extends JpaRepository<ServiceOrder, Long> {
}
