package ru.database.springmasterdb.store;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {

    List<WorkOrder> findAllByIsDone(Boolean isDone, Sort isNeedCallSort);

    List<WorkOrder> findAllByIsNeedCall(Boolean isNeedCall, Sort isNeedCallSort);
}
