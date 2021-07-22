package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.WorkOrder;

public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {
}
