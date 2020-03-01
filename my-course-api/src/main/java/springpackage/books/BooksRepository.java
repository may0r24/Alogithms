package springpackage.books;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, String>{
	
}
