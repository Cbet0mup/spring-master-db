package ru.database.springmasterdb.store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<Notes, Integer> {
    Notes getNotesByIdWorkOrder (Integer idWorkOrders);
}
