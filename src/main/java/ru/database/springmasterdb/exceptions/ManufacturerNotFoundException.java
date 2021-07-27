package ru.database.springmasterdb.exceptions;

public class ManufacturerNotFoundException extends Exception {
    public ManufacturerNotFoundException(String except){
        super(except);
    }

}