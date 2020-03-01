package samplepackage.webcalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleCalculatorController {

	@Autowired
	private SimpleCalculatorServices simpleCalculatorServices;
	
	@RequestMapping("/total")
	public int getAns(){
		return simpleCalculatorServices.add();
	}
}
