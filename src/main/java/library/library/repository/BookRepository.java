package library.library.repository;

import org.springframework.stereotype.Repository;

import library.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
