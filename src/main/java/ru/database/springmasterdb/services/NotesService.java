package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.NotesDTO;

public interface NotesService {
    NotesDTO getNotes(Integer idWorkOrder);
}
