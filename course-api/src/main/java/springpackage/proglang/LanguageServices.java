package springpackage.proglang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LanguageServices {

	private List<Languages> langs = new LinkedList<>(Arrays.asList(
			new Languages("Java", "Programming Language", "sweet!"),
			new Languages("JavaScript", "Scripting Language", "hmm!"),
			new Languages("HTML", "Text Based Language", "cool!")
			
			));
	public List<Languages> getAllLangs(){
		return langs;
	}
	
	public Languages getLanguages(String name) {
		return langs.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	public void addLanguage(Languages langue) {
		langs.add(langue);
	}

	public void updateLanguage(String name, Languages language) {
		
		for(int i = 0; i < langs.size(); i++) {
			Languages l = langs.get(i);
			if(l.getName().equals(name)) {
				langs.set(i, language);
			}
		}
		
	}
}
