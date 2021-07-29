package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.database.springmasterdb.store.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}
