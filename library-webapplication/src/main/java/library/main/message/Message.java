package library.main.message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Message {
	
	@RequestMapping("/message")
	public String message() {
		return "Online!";
		
	}

}
