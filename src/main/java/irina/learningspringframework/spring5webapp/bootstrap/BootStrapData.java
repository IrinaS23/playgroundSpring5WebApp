package irina.learningspringframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import irina.learningspringframework.spring5webapp.domain.Author;
import irina.learningspringframework.spring5webapp.domain.Book;
import irina.learningspringframework.spring5webapp.repositories.AuthorRepository;
import irina.learningspringframework.spring5webapp.repositories.BookRepository;


@Component
public class BootStrapData  implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Author markM = new Author("Mark", "Manson");
		Book subtleArt = new Book("The Subtle Art of Not Giving a F*ck", "123456");		
		markM.getBooks().add(subtleArt);
		subtleArt.getAuthors().add(markM);
		
		authorRepository.save(markM);
		bookRepository.save(subtleArt);
		
		Author asimov = new Author("Isaac", "Asimov");
		Book foundation = new Book("Foundation and the Empire", "45678");
		
		authorRepository.save(asimov);
		bookRepository.save(foundation);
		
		System.out.println("Startet in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		
		
		
	}

	

	
}
