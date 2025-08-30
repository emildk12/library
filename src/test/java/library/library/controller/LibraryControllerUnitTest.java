package library.library.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import library.library.controllers.LibraryController;
import library.library.model.Book;
import library.library.service.BookServiceImpl;

@WebMvcTest(LibraryController.class)
public class LibraryControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookServiceImpl bookService;

    private Book book;
    private String author;
    private String title;

    @BeforeEach
    public void setup() {
        title = "Fyrsten";
        author = "Machiavelli";
        book = new Book(1L, title, author);
    }

    @Test
    public void addBookTest() throws Exception {

        when(bookService.addBook(title, author)).then(invocation -> {
            return book;
        });
        
        mockMvc.perform(post("/api/addbook?title="+title+"&author="+author))
            .andExpectAll(  status().isCreated(),
                            jsonPath("$.title", is(book.getTitle())),
                            jsonPath("$.author", is(book.getAuthor()))                
            );
    }

    @Test
    public void findAllBooksTest() throws Exception {
        List<Book> booklList = new ArrayList<>();
        booklList.add(book);
        when(bookService.findAllBooks()).then(invocation -> {
            return booklList;
        });

        mockMvc.perform(get("/api/findallbooks"))
            .andExpectAll(  status().isOk(),
                            jsonPath("$.size()", is(booklList.size())));
    }
    @Test
    public void deleteBook() throws Exception {
        doNothing().when(bookService).deleteBook(book.getId());

        mockMvc.perform(delete("/api/deletebook?id=" + book.getId()))
            .andExpect(status().isOk());
    }
}
