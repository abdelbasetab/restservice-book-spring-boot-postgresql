package com.example.bookmanagement.com.example.bookmanagement.service;

import com.example.bookmanagement.com.example.bookmanagement.exception.BookNotFoundException;
import com.example.bookmanagement.com.example.bookmanagement.model.Book;
import com.example.bookmanagement.com.example.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {


    private BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    /**
     * insert book into database
     * @param book
     * @return saved book
     */
    public Book insert(Book book) {

        return bookRepository.save(book);

    }


    /**
     * delete book by id
     * @param id
     * @return
     */
    public String deleteById(Long id) {

        if(bookRepository.existsById(id)){

            bookRepository.deleteById(id);

            return "Book with ID = " + id + " deleted";
        }

        return "there is no book with such ID = " + id +" in the database";




    }


    /**
     * Retrieves a list of books from the database whose titles contain the specified word.
     *
     * @param word The word to search for within book titles
     * @return A list of books that have the specified word in their title;
     */
    public List<Book> getAllBooksWithTitle(String word){

        return bookRepository.getAllBooksWithTitle(word);

    }


    /**
     * @return all books from database
     */
    public  List<Book> getAllBooks() {

            return bookRepository.findAll();

    }


    /**
     * @param id
     * @return a book with such id from database or throw exception when note exits in the database
     */
    public Book findBookById(Long id) {

        if(bookRepository.existsById(id)){

            return bookRepository.findById(id).get();

        }
        else
            throw new BookNotFoundException(id);

    }


}
