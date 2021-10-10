package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ServiceOrderRepo extends JpaRepository<ServiceOrder, Integer> {
    @Query("FROM ServiceOrder")
    List<ServiceOrder> getAll();
}
