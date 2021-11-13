package ru.database.springmasterdb.store;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {
    @Query("FROM WorkOrder w where w.isDone = ?1 or w.isDoneIsCalled = ?2")
    List<WorkOrder> findAllByIsDoneAndIsDoneIsCalled(Boolean isDone, Boolean isDoneIsCalled, Sort isNeedCallSort);

    List<WorkOrder> findAllByIsNeedCall(Boolean isNeedCall, Sort isNeedCallSort);

    List<WorkOrder> findAllByCreatedAt(String date, Sort createdAt);

    @Query("FROM WorkOrder w where w.engineer.id = ?1 and w.isAccepted = ?2 and w.isDone = ?3")
    List<WorkOrder> findAllByEngineerAndIsAcceptedAnAndIsDone(Integer id, Boolean isAccepted, Boolean isDone, Sort isAcceptedId);
}
