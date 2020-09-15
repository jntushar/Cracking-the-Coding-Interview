/*
 * Question 8.12
 * 
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same
 * row, column, or diagonal. In the case, "diagonal" means all diagonals, not just the two that bisect the board.
 * 
 * */

package RecursionAndDynamicProgramming;

public class EightQueen {

	public static void main(String[] args) {
		int n = 8;
		int[][] chess = new int[n][n];
		printNQueens(chess, "", 0);
	}
	
	public static void printNQueens(int[][] chess, String qsf, int row) {
		if(row == chess.length) {
			System.out.println(qsf);
			return;
		}
		
		for(int col = 0; col<chess.length; col++) {
			if(isSafe(chess, row, col)) {
				chess[row][col] = 1;
				printNQueens(chess, qsf + row + "-" + col + ",", row+1);
				chess[row][col] = 0;
			}
		}
	}
	
	public static boolean isSafe(int[][] chess, int row, int col) {
		// vertically 
		for(int i = row - 1, j = col; i>=0 ;i--) {
			if(chess[i][j] == 1)
				return false;
		}
		
		for(int i = row - 1, j = col - 1; i>=0 && j>=0 ; i--, j--) {
			if(chess[i][j] == 1)
				return false;
		}
		
		for(int i = row - 1, j = col + 1; i>=0 && j<chess.length ; i--, j++) {
			if(chess[i][j] == 1)
				return false;
		}
				
		return true;
	}
	

}
