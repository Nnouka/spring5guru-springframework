package guru.springframework.spring5.repositories;

import guru.springframework.spring5.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
