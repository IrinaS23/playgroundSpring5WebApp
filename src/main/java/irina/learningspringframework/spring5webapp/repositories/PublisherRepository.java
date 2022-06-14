package irina.learningspringframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import irina.learningspringframework.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
