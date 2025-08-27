package library.library.service;
import java.util.List;

import library.library.model.Book;

public interface BookService {
    public List<Book> findAllBooks();
    public Book findBookById(Long id);
    public String addBook(String title, String author);
    // public String deleteBook(??);
    // public String editBook(??);
}
