package com.example.bookmanagement.com.example.bookmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {


    public BookNotFoundException( Long id){
        super(String.format("Book with ID %s not found in the database ", id));
    }

}
