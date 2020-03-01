package samplepackage.webcalc;

import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorServices {
	
	SimpleCalculator sc = new SimpleCalculator(1, 2, 3);

	public int add() {
		int ans = sc.getNum1() + sc.getNum2() + sc.getNum3();
		return ans;
	}

}
