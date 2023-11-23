package com.example.bookmanagement.com.example.bookmanagement.controller;


import com.example.bookmanagement.com.example.bookmanagement.model.Book;
import com.example.bookmanagement.com.example.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {



    BookService bookService;


    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    /**get all books from database*/
    @GetMapping("getAll")
    public ResponseEntity<List<Book>> getAllBooks() {

        try {

            return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);

        }catch(Exception ex){

            ex.printStackTrace();
        }

        //if something went wrong
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }


    /** save book  */
    @PostMapping("insert")
    public ResponseEntity insert(@RequestBody Book book) {

        return  new ResponseEntity<>( bookService.insert(book) ,HttpStatus.CREATED);
    }

    /** get book by id   */
    @GetMapping("/{id}")
    public  ResponseEntity<?> findBookById(@PathVariable Long id) {

        try {

            Book book =  bookService.findBookById(id);

            return new ResponseEntity<>(book,HttpStatus.FOUND);

        }catch(Exception ex){

            ex.printStackTrace();
        }
          return new ResponseEntity<>( "no Book with ID: " + id + " in the database" , HttpStatus.NOT_FOUND);

    }

    /** delete book by id*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable Long id){

        return bookService.deleteById(id);

    }

    /**
     *get all books with such title
     */
    @GetMapping("search/{word}")
    public ResponseEntity<List<Book>> getAllBooksWithTitle( @PathVariable String word){

        try {

            return new ResponseEntity<>(bookService.getAllBooksWithTitle(word), HttpStatus.OK);

        }catch(Exception e){

            e.printStackTrace();

        }

        //if something went wrong
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }

}
