package guru.springframework.spring5.repositories;

import guru.springframework.spring5.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
