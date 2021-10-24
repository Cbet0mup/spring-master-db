package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.NotesDTO;
import ru.database.springmasterdb.factories.NotesDTOFactory;
import ru.database.springmasterdb.store.Notes;
import ru.database.springmasterdb.store.NotesRepo;

@Service
public class NotesServiceImpl implements NotesService{

    private final NotesRepo notesRepo;
    private final NotesDTOFactory notesDTOFactory;

    public NotesServiceImpl(NotesRepo notesRepo, NotesDTOFactory notesDTOFactory) {
        this.notesRepo = notesRepo;
        this.notesDTOFactory = notesDTOFactory;
    }

    @Override
    public NotesDTO getNotes(Integer idWorkOrder) {
        Notes notes = notesRepo.getNotesByIdWorkOrder(idWorkOrder);

        return notesDTOFactory.createNotesDTO(notes);
    }
}
