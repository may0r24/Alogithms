package test;

public class Test8 {

	static int minimumDays(int rows, int columns, int[][] grid) {
		int result = 0;
		
		int[][] inGrid = new int[rows][columns];

		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < columns; col++) {
				inGrid [row][col] = grid[row][col];
			}
		}
		
//		return result;
	}
	
	public static void main(String...strings) {
		int [][] arr = {{1,0}, {0,1}};
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.println(arr[i][j]);	
			}
		}	
	}
}
