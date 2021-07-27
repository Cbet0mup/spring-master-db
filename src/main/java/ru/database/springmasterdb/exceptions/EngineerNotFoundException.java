package ru.database.springmasterdb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EngineerNotFoundException extends Exception {
   public EngineerNotFoundException(String except){
       super(except);
    }

}
