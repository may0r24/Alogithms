package test;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 5, 5, 5, 8, 8, 8};
		System.out.println(isStepped(numbers));
	}
	public static int isStepped(int[] arr) {
		Boolean valid = null;
		int validOccurence = 3;
		List<Integer> occurence = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {

				if (arr[i] == arr[j]) {
					count++;
				} else {}
			}
			occurence.add(count);
		}
		int res = -1;
		for (int i : occurence) {
			if (i < validOccurence) {
				res = 0;
				valid = false;
				break;
			} else {
				res = 1;
				valid = true;
			}
		}
		if (valid) {
			res = -1;
			for (int i = 0; i <= arr.length; i++) {
				if (i == arr.length - 1) {
					break;
				}
				if (arr[i] <= arr[i + 1]) {
					res = 1;
				} else {
					res = 0;
					break;
				}
			}
			return res;
		} else {
			return res;
		}
	}
}