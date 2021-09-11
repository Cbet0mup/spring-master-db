package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {

    //@Query("select w from WorkOrder w where w.isDone = :isDone")
    List<WorkOrder> findAllByIsDone(Boolean isDone);

   // @Query("select i from WorkOrder i where i.isNeedCall = :isNeedCall")
    List<WorkOrder> findAllByIsNeedCall(Boolean isNeedCall);
}
