package library.library.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;

import library.library.model.Book;
import library.library.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTest {
    
    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    private String title;
    private String author;
    private Book book;

    @BeforeEach
    public void setup() {
        title = "Fyrsten";
        author = "Machiavelli";
        book = new Book(null, title, author);
    }

    @Test
    public void addBookTest() {
        when(bookRepository.save(book)).thenReturn(book);
        Book savedBook = bookService.addBook(title, author);

        assertThat(savedBook.getTitle()).isEqualTo(book.getTitle());
    }

    @Test
    public void findAllBooksTest() {
        List<Book> booklList = new ArrayList<>();
        booklList.add(book);
        when(bookRepository.findAll()).thenReturn(booklList);

        List<Book> foundBookList = bookService.findAllBooks();

        assertThat(foundBookList.get(0)).isEqualTo(booklList.get(0));
        assertThat(foundBookList.size()).isGreaterThan(0);
    }

    @Test
    public void deleteBookTest() {
        doNothing().when(bookRepository).deleteById(book.getId());
        bookService.deleteBook(book.getId());

        verify(bookRepository, times(1)).deleteById(book.getId());
    }    
}
