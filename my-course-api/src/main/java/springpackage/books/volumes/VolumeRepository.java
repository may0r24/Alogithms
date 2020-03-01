package springpackage.books.volumes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VolumeRepository extends CrudRepository<Volume, String>{
	
	public List<Volume> findByBookId(String bookId);
}
