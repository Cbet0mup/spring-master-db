package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {
    @Query("FROM Manufacturer ")
    List<Manufacturer> getAll();
}
