package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.database.springmasterdb.store.entities.WorkOrder;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {
}
