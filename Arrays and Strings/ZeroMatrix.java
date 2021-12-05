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
	
	private static int[][] getZeroMatrix(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for(int i=0; i<row.length; i++){
            if(row[i]){
                for(int m=0; m<matrix[0].length; m++){
                    matrix[i][m] = 0;
                }
            }
        }
        for(int j=0; j<column.length; j++){
            if(column[j]){
                for(int n=0; n<matrix.length; n++){
                    matrix[n][j] = 0;
                }
            }
        }
        return matrix;
    }
	
    private static void print(int[][] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
