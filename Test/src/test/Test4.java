package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {

		int[] array = { 1, 1, 2, 2, 2, 1, 1};
		System.out.println(is121Array(array));
	}

	public static int is121Array(int[] array) {
		List<int[]> arrayList = Arrays.asList(array);
		List<Integer> beginValues = new ArrayList<>();
		List<Integer> endValues = new ArrayList<>();
		List<Integer> middleValues = new ArrayList<>();
		Integer flag = null;
		Integer index = 0;
		Boolean valid = null;
		int length = -1;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 1 && array[i] != 2) {
				flag = 0;
				valid = false;
				break;
			} 
				else {
				if (array[i] == 2) {
					valid = true;
					break;
				} else {
					index++;
					valid = true;
				}
				}
		}
		for(int i: array) {
			if(i == 1 ) {
				
			}
		}
		
		if (!valid) {
			return flag;
		} else {
			for (int i = 0; i < index; i++) {
				beginValues.add(array[i]);
			}
			for (int i = index + 1; i < arrayList.size(); i++) {
				endValues.add(array[i]);
			}

			length = beginValues.size();
			int bound = arrayList.size() - (length * 2);

			for (int j = length; j < bound + length; j++) {

				middleValues.add(array[j]);
			}

			if (beginValues.equals(endValues)) {
				flag = 1;
			}
			for (Integer i : middleValues) {
				if (i != 2) {
					flag = 0;
					break;
				} else {
					flag = 1;
				}
			}
			return flag;
		}
	}
}