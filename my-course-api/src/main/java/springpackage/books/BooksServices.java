package springpackage.books;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksServices {
	
	@Autowired
	private BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		List<Books> books = new LinkedList<>();
		booksRepository.findAll().forEach(books::add);
		return books;
	}

	public Books searchBooks(String id) {
		return booksRepository.findOne(id);
	}

	public void addBooks(Books book) {
		booksRepository.save(book);
	}

	public void updateBooks(String id, Books book) {
		booksRepository.save(book);
	}

	public void deleteBooks(String id) {
		booksRepository.delete(id);
	}
}
