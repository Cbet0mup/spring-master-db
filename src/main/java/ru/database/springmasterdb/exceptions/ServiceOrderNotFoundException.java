package ru.database.springmasterdb.exceptions;

public class ServiceOrderNotFoundException extends Exception {
    public ServiceOrderNotFoundException(String except){
        super(except);
    }

}
