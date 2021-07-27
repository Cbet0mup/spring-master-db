package ru.database.springmasterdb.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String except){
        super(except);
    }

}
