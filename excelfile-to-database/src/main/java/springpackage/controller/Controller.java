package springpackage.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springpackage.model.Branch;
import springpackage.utils.Utils;

@RestController
@RequestMapping(value = "/home")
public class Controller {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return "Hello";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/upload/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<Object> excel(@RequestParam("file") MultipartFile file) throws Exception {
		Branch branchObj = new Branch();
//		File f = new File(file.getOriginalFilename());
		List<Object> branch =  Utils.readFromCsvFile(file.getInputStream(), Branch.class);
		for(int i = 0; i < branch.size(); i++) {
			branchObj = (Branch) branch.get(i);
			if(branchObj != null) {
			}
		}
		return branch;
	}
}
