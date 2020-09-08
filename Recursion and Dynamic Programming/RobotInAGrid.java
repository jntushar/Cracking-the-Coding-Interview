/*
 * Question 8.2
 * 
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two direction, right and down, but certain cells are "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 * 
 * */
package RecursionAndDynamicProgramming;

public class RobotInAGrid {

	public static void main(String[] args) {
		int [][]grid = {{0,0,0},
						{0,1,0},
						{0,0,0}};
		
		System.out.println(getPaths(grid));

	}
	
	public static int getPaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] res = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			if(grid[i][0] == 0)
				res[i][0] = 1;
			else
				break;
		}
		
		for(int i = 0; i < n; i++) {
			if(grid[0][i] == 0)
				res[0][i] = 1;
			else
				break;
		}
		
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(grid[i][j] == 1)
					res[i][j] = 0;
				else
					res[i][j] = res[i-1][j]  + res[i][j-1];
			}
		}
		
		return res[m-1][n-1];
	}

}
