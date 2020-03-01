package test;

public class Test2 {

	public static void main(String[] args) {
		Integer[] array = { 3, 2, 1, 4, 1 };
		System.out.println(isCenterredArray(array));
	}

	public static int isCenterredArray(Integer[] array) {

		int arrayLength = array.length;
		int result = -1;

		if (arrayLength % 2 == 0) {
			return result = 0;
		}
		if (arrayLength == 1) {
			return result = 1;
		} else {
			int middleValue = array[array.length / 2];
			int middleValueIndex = array.length / 2;
			for (int i = 0; i < array.length; i++) {
				if (i == middleValueIndex) {
					//skip
				} else {
					if (array[i] == middleValue) {
						result = 0;
						break;

					} else {
						if (array[i] < middleValue) {
							result = 0;
							break;
						} else {
							result = 1;
						}
					}
				}

			}
			return result;
		}
	}

}
