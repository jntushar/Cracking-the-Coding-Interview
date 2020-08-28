/*
 * Question 1.8
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * 
 * */
package ArraysAndStrings;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{4,2,3,2,9},
						  {5,9,6,0,8},
						  {2,9,9,4,9},
						  {1,3,2,7,8}};
		print(getZeroMatrix(matrix));
	}
	
	static int[][] getZeroMatrix(int[][] matrix){
		int row=0,col=0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					row = i;
					col = j;
					break;
				}
			}
		}
		
		//to nullify row
		for(int x=0; x<matrix[row].length; x++)
			matrix[row][x] = 0;
			
		//to nullify column
		for(int x=0; x<matrix.length; x++)
			matrix[x][col] = 0;
		return matrix;
	}
	
	static void print(int[][] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) { 
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
