package predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	
	public static void print(List<String> users, Predicate<String> empPredicate) {
		System.out.println("!! 'Predicate List ' Output !!");
		for(String name: users) {
			if(empPredicate.test(name));
				System.out.println(name);
		}
		System.out.println("\n");
	}
	
	public static void main(String... args) {
		Predicate<String> predicateString = s -> {
			return s.equals("Java Code Geek");
		};
		
		System.out.println("!! 'Predicate String ' Output !!");
		System.out.println(predicateString.test("Java Code Geek"));
		System.out.println(predicateString.test("Java Code"));

	}

}
