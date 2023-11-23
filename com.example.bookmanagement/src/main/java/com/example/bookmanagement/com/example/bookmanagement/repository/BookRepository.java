package com.example.bookmanagement.com.example.bookmanagement.repository;

import com.example.bookmanagement.com.example.bookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;


public interface BookRepository extends JpaRepository<Book,Long> {


    @Query(value = "select * from book where book.title LIKE  %?1% ", nativeQuery = true)
    public ArrayList<Book> getAllBooksWithTitle(String word);
}
