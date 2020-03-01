package test;

public class Test6 {

	public static void main(String[] args) {
		
		int limit = 200000;
		Long sum = 0L;
		
		for(int i = 1; i <= limit; i++) {
			int count = 0;
			for(int div = i; div >= 1; div--) {
				if(i % div == 0) {
					count += 1;
				}
			}
			if(count == 2) {
				sum += i;
			}
		}
		System.out.print("Sum: " + sum);
	}
}
//a: 1709600813
//b: 454333422
//c: 826892723