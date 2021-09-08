package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;

import java.util.List;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {

    @Query("select w from WorkOrder w where w.isDone = :isDone order by w.id ASC")
    List<WorkOrder> findAllByIsDone(@Param("isDone") Boolean isDone);
}
