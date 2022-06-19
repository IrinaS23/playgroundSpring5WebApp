package irina.learningspringframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import irina.learningspringframework.spring5webapp.repositories.BookRepository;

@Controller //spring managed 
public class BookController {

	private final BookRepository bookrepository; // spring will INJECT a bookrepository
	
	
	
	public BookController(BookRepository bookrepository) {
		super();
		this.bookrepository = bookrepository;
	}

	

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookrepository.findAll());

		return "books/list"; //returns the view
	}
}
