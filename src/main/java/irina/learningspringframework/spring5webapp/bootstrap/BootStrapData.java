package irina.learningspringframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import irina.learningspringframework.spring5webapp.domain.Author;
import irina.learningspringframework.spring5webapp.domain.Book;
import irina.learningspringframework.spring5webapp.domain.Publisher;
import irina.learningspringframework.spring5webapp.repositories.AuthorRepository;
import irina.learningspringframework.spring5webapp.repositories.BookRepository;
import irina.learningspringframework.spring5webapp.repositories.PublisherRepository;


@Component
public class BootStrapData  implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sarted in Bootstrap");
		
		Publisher publisher = new Publisher();
		publisher.setName("Nemira");
		publisher.setCity("Bucharest");
		publisher.setState("Romania");
		
		publisherRepository.save(publisher);
		
		Author markM = new Author("Mark", "Manson");
		Book subtleArt = new Book("The Subtle Art of Not Giving a F*ck", "123456");		
		markM.getBooks().add(subtleArt);
		subtleArt.getAuthors().add(markM);
		
		subtleArt.setPublisher(publisher);
		publisher.getBooks().add(subtleArt);
		
		authorRepository.save(markM);
		bookRepository.save(subtleArt);
		publisherRepository.save(publisher);
		
		Author asimov = new Author("Isaac", "Asimov");
		Book foundation = new Book("Foundation and the Empire", "45678");
		asimov.getBooks().add(foundation);
		foundation.getAuthors().add(asimov);
		
		foundation.setPublisher(publisher);
		publisher.getBooks().add(foundation);
		
		
		authorRepository.save(asimov);
		bookRepository.save(foundation);
		publisherRepository.save(publisher);
		
		System.out.println("Startet in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
		
		
		
	}

	

	
}
