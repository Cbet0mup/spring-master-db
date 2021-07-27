package ru.database.springmasterdb.exceptions;

public class StatusNotFoundException extends Exception {
    public StatusNotFoundException(String except){
        super(except);
    }

}
