package springpackage.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import springpackage.dao.TitlesDao;
import springpackage.model.Titles;

@Service
public class TitleService {

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	@Autowired
	private TitlesDao titlesDao;

	public int create(Titles title) {
		return titlesDao.save(title).getId();
	}

	public List<Titles> findByName(String name) throws Exception {
		return titlesDao.findByName(name);
	}

	public List<Future<Object>> bulkCreated(List<Object> objectList) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<Callable<Object>> taskList = new ArrayList<>();
		int position = 1;
		for (Object item : objectList) {
			Titles title = mapper.convertValue(item, Titles.class);
			taskList.add(new Task(title, position));
			position++;
		}
		List<Future<Object>> result = executorService.invokeAll(taskList);
		return result;
	}

	private class Task implements Callable<Object> {

		private Titles title;
		private int position;

		private Task(Titles titles, int position) {
			this.title = titles;
			this.position = position;
		}

		@Override
		public Object call() throws Exception {
			String report = null;
			Integer id = null;
			if (title != null) {
				List<Titles> existingTitle = findByName(title.getName());
				if (title.getName() == null) {
					report = "Title name at " + position + " is empty";
				} else {
					if (existingTitle != null) {
						report = "Title name at " + position + " already exist";
					} else {
						id = create(title);
					}
				}
			}
			if (report != null) {
				return report;
			} else {
				return id;

			}
		}
	}
}
