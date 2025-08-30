package library.library.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import library.library.model.Book;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryUnitTest {
    
    // Uses H2 in-memory databse for testing purposes

    @Autowired
    private BookRepository bookRepository;

    private String author;
    private String title;
    private Book book;
    
    @BeforeEach
    public void setup() {
        title = "Fyrsten";
        author = "Machiavelli";
        book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addBookTest() {

        bookRepository.save(book);

        Assertions.assertThat(book.getAuthor()).isEqualTo(author);
        Assertions.assertThat(book.getTitle()).isEqualTo(title);
        Assertions.assertThat(book.getId()).isEqualTo(1L);
    }


    @Test
    @Order(2)
    public void findAllBooksTest() {
        List<Book> bookList = bookRepository.findAll();
        Assertions.assertThat(bookList.get(0).getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void findBookByIdTest() {
        Book book = bookRepository.findById(1L).orElse(null);
        Assertions.assertThat(book.getTitle()).isEqualTo(title);
    }
    @Test
    @Order(4)
    public void deleteBookTest() {
        bookRepository.deleteById(1L);
        Book book = bookRepository.findById(1L).orElse(null);
        Assertions.assertThat(book).isNull();
    }
}
