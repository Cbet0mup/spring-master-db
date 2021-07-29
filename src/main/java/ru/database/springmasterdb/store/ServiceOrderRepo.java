package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.ServiceOrder;

public interface ServiceOrderRepo extends JpaRepository<ServiceOrder, Long> {
}
