package ru.database.springmasterdb.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.entities.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}
