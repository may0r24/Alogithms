package library.main.booksstatus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BooksServices {
	
	private List<Books> booksList = new LinkedList<>(Arrays.asList(
			
				new Books("B01", "CoreJava", "Programming", "Available"),
				new Books("B02", "Mathematics", "Maths", "Available"),
				new Books("B03", "Physics", "Phy", "Available")
			));

	public List<Books> getAllBooks() {
		return booksList;
	}

	public Books searchBooks(String id) {
		Books book = null;
		for(int i = 0; i < booksList.size(); i++) {
			Books b = booksList.get(i);
			if(b.getBookId().equals(id)){
				book = booksList.get(i);
			}
		}
		return book;
	}

	public void addBooks(Books book) {
		booksList.add(book);
	}

	public void updateBooks(String id, Books book) {
		for(int i = 0; i < booksList.size(); i++) {
			Books b = booksList.get(i);
			if(b.getBookId().equals(id)) {
				booksList.set(i, book);
			}
		}
	}

	public void deleteBooks(String id) {
		for(int i = 0; i < booksList.size(); i++) {
			Books b = booksList.get(i);
			if(b.getBookId().equals(id)){
				booksList.remove(i);
			}
		}
	}
}
