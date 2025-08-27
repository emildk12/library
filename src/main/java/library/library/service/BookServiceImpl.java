package library.library.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.library.model.Book;
import library.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookRepository bookRepository;

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
}
