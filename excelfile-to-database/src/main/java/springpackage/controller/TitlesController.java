package springpackage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springpackage.model.Titles;
import springpackage.services.TitleService;
import springpackage.utils.Utils;

@RestController
@RequestMapping(value = "/v1/app")
public class TitlesController {
	
	@Autowired
	private TitleService titlesService;

	@RequestMapping(method = RequestMethod.POST, value = "/upload/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<Object> excel(@RequestParam("file") MultipartFile file) throws Exception {
		List<Object> out = new ArrayList<>();
		List<Object> titlesList =  Utils.readFromCsvFile(file.getInputStream(), Titles.class);	
		List<Future<Object>> result = titlesService.bulkCreated(titlesList);
		for(Future<Object> item :  result) {
			out.add(item.get());
		}
		return out;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/find/name/{name}",
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Titles> retrieveTitle(@PathVariable String name) throws Exception {
		return titlesService.findByName(name);
	}
}
