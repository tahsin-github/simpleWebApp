package tahsin.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tahsin.springframework.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
