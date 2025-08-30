package library.library.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.library.model.Book;
import library.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public String addBook(String title, String author) {
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        bookRepository.save(b);
        return "Book added!";
    }
    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book deleted!";
    } 
}
