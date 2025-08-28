package library.library.controllers;

import library.library.service.BookServiceImpl;

import library.library.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private BookServiceImpl bookServiceImpl;
    
    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks() {
        return bookServiceImpl.findAllBooks();
    }
    @GetMapping("/findBook/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookServiceImpl.findBookById(id);
    }
    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author) {
        return bookServiceImpl.addBook(title, author);
    }
    // @DeleteMapping("/deleteBook")
    // public String deleteBook(@RequestParam ??) {
    //     return bookServiceImpl.deleteBook(??);
    // }

    // @DeleteMapping("/deleteAllBooks")
    // public String deleteAllBooks(@RequestParam ??) {
    //     return bookServiceImpl.deleteAllBooks(??);
    // }

}
