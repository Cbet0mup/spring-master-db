package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {
}
