package fi.kulmala.Bookstore.web;

import fi.kulmala.Bookstore.domain.Book;
import fi.kulmala.Bookstore.domain.BookRepository;
import fi.kulmala.Bookstore.domain.Category;
import fi.kulmala.Bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository repository2;

	public void doSomething() {
		List<Book> books = repository.findByTitle("*");
	}

	// Useless?
	public void doAnotherThing() {
		List<Category> categories = repository2.findByName("*");
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/")
	public String index() {
		return "Nothing to see here! Head to /booklist";
	}

	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		// category(s)
		model.addAttribute("categories", repository2.findAll());
		return "addbook";
	}

	@PostMapping(value = "/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", repository2.findAll());
		return "editbook";
	}
	
	// API endpoints
	
	@RequestMapping(value = "/book", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value = "/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookid) {
		return repository.findById(bookid);
	}

}
