package test;


public class Test3 {

	public static void main(String[] args) {
		int [] array = {1,2,3,4,5, 5,4};
		System.out.print(hasSingleMaximum(array));
	}

	public static int hasSingleMaximum(int[]array) {	
		Integer flag = null;
		Integer highestElement = null;
		
		if(array.length == 0) {
			flag = 0;
		}
		else if(array.length == 1) {
			flag = 1;
		}
		else {
			for (int i = 0; i < array.length; i++) {
				for (int j = 1; j < array.length - 1; j++) {
					if (array[i] > array[j]) {
						highestElement = array[i];
					}
				}
			}
			int occurrence = 0;
			for (Integer i : array) {
				if (i == highestElement) {
					occurrence++;
				}
			}
			if (occurrence == 1) {
				flag = 1;
			}
			if (occurrence > 1) {
				flag = 0;
			}
		}	
		return flag;
	}
}