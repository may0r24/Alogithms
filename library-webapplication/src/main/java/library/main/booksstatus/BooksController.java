package library.main.booksstatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@Autowired
	private BooksServices booksServices;
	
	@RequestMapping("/allbooks")
	public List<Books> getAllBooks() {
		return booksServices.getAllBooks();
	}
	@RequestMapping("/searchbooks/{id}")
	public Books searchBooks(@PathVariable String id) {
		return booksServices.searchBooks(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/addbooks")
	public String addBooks(@RequestBody Books book) {
		booksServices.addBooks(book);
		return "Successfully Added!";
	}
	@RequestMapping(method=RequestMethod.PUT, value="/updatebooks/{id}")
	public String updateBooks(@PathVariable String id, @RequestBody Books book) {
		booksServices.updateBooks(id, book);
		return "Updated!";
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/deletebooks/{id}")
	public String deleteBooks(@PathVariable String id) {
		booksServices.deleteBooks(id);
		return "Deleted!";
	}
}
