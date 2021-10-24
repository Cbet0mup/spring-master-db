package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.NotesDTO;
import ru.database.springmasterdb.store.Notes;

@Component
public class NotesDTOFactory {
    public NotesDTO createNotesDTO(Notes notes){
        return NotesDTO.builder()
                .id(notes.getId())
                .idWorkOrder(notes.getIdWorkOrder())
                .messages(notes.getMessages())
                .build();
    }
}
