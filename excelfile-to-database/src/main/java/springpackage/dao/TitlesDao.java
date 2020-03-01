package springpackage.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import springpackage.model.Titles;

public interface TitlesDao extends CrudRepository<Titles, Integer>{
	
	public List<Titles> findByName(String name);
	
}
