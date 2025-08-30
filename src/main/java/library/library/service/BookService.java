package library.library.service;
import java.util.List;

import library.library.model.Book;

public interface BookService {
    public List<Book> findAllBooks();
    public Book findBookById(Long id);
    public Book addBook(String title, String author);
    public void deleteBook(Long id);
    // public String editBook(??);
}
