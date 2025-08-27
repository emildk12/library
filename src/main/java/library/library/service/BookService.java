package library.library.service;
import library.library.model.Book;

public interface BookService {
    public Book findBookById(Long id);
    public String addBook(String title, String author);
}
