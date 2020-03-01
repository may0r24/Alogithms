package samplepackage.showmessagepackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowMessage {

	@RequestMapping("/message")
	public String showMessage() {
		return "Success!";
	}
}
