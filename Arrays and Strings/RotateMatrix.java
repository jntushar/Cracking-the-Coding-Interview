/*
 * Question 1.7
 * 
 * Given an image represented by NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 * */
package ArraysAndStrings;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] image = {{1,1,1,1,1},
						 {2,2,2,2,2},
					     {3,3,3,3,3},
					     {4,4,4,4,4},
					     {5,5,5,5,5}};
		print(rotate90degree(image));
	}
	
	static int[][] rotate90degree(int[][] image) {
		for(int layer = 0; layer < image.length/2; layer++) {
			int first = layer;
			int last = image.length - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = image[layer][i];
				
				//left -> top
				image[layer][i] = image[last-offset][first];
				
				//bottom -> left
				image[last-offset][first] = image[last][last-offset];
				
				//right -> bottom
				image[last][last-offset] = image[i][last];
				
				//top -> right
				image[i][last] = top;
			}
		}
		
		return image;
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
