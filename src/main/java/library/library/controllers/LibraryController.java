package library.library.controllers;

import library.library.service.BookServiceImpl;

import library.library.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private BookServiceImpl bookServiceImpl;
    
    @GetMapping("/findallbooks")
    public List<Book> findAllBooks() {
        return bookServiceImpl.findAllBooks();
    }
    @GetMapping("/findbook")
    public Book findBookById(@RequestParam  Long id) {
        return bookServiceImpl.findBookById(id);
    }
    @PostMapping("/addbook")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestParam String title, @RequestParam String author) {
        return bookServiceImpl.addBook(title, author);
    }
    @DeleteMapping("/deletebook")
    public void deleteBook(@RequestParam Long id) {
        bookServiceImpl.deleteBook(id);
    }

    // @DeleteMapping("/deleteallbooks")
    // public String deleteAllBooks(@RequestParam ??) {
    //     return bookServiceImpl.deleteAllBooks(??);
    // }

}
