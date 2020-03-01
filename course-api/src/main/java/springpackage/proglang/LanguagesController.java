package springpackage.proglang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {

	@Autowired
	private LanguageServices languageServices;
	
	@RequestMapping("/languages")
	public List<Languages> lang(){
		return languageServices.getAllLangs();
				
	}
	
	@RequestMapping("/languages/{name}")
	public Languages getTopic(@PathVariable String name) {
		return languageServices.getLanguages(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/languages")
	public void addLanguage(@RequestBody Languages langue) {
		languageServices.addLanguage(langue);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/languages/{name}")
	public void updateLanguage(String name,@ PathVariable Languages language) {
		languageServices.updateLanguage(name, language);
	}
}
