package springpackage.main.quickmessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickMessage {

	@RequestMapping("/status")
	public String show() {
		return "good!";
	}
}
