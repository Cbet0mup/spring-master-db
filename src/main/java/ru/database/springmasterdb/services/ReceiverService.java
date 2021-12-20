package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.ReceiverDTO;

public interface ReceiverService {
    void createNewReceiver(ReceiverDTO receiverDTO);
}
