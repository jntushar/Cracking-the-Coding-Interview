/*
 * Question 8.10
 * 
 * Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original colors.
 * 
 * */

package RecursionAndDynamicProgramming;

public class PaintFill {

	public static void main(String[] args) {
		int[][] image = {{1,0,0,1,0,1,1,1},
						 {1,0,0,0,0,1,0,0},
						 {1,1,1,1,1,1,1,1},
						 {0,1,0,1,0,1,1,1},
						 {0,0,0,0,0,0,0,0},
						 {1,1,1,0,0,1,1,0},
						 {1,1,0,0,0,0,1,1}};
		
		paintFill(image, 6, 0, 1, 4);
		
		for(int i = 0; i<image.length ; i++) {
			for(int j = 0; j<image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void paintFill(int[][] image, int row, int col, int oldColor, int newColor){
		
		if(row<0 || col<0 || row>image.length-1 || col>image[0].length-1){
			return;
		}
		
		if(image[row][col] == oldColor) {
			image[row][col] = newColor;
			paintFill(image, row+1, col, oldColor, newColor);
			paintFill(image, row-1, col, oldColor, newColor);
			paintFill(image, row, col+1, oldColor, newColor);
			paintFill(image, row, col-1, oldColor, newColor);
		}
	}
}
