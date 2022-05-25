package irina.learningspringframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import irina.learningspringframework.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
