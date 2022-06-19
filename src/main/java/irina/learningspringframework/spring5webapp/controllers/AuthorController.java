package irina.learningspringframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import irina.learningspringframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

		private final AuthorRepository authorrepository;

		public AuthorController(AuthorRepository authorrepository) {
			super();
			this.authorrepository = authorrepository;
		}
		
		@RequestMapping("/authors")
		public String getAuthors(Model model) {
			model.addAttribute("authors", authorrepository.findAll());
			
			return "authors/list"; //setup mapping to the view
			
			
		}
}
