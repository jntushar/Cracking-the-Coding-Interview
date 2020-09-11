/*
 * Question 8.5
 * 
 * Write a recursive function to multiply two positive integers without using * operator (or / operator).
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 * 
 * */

package RecursionAndDynamicProgramming;

public class RecursiveMultiply {

	public static void main(String[] args) {
		System.out.println(getMultiply(5, 7));
	}
	
	public static int getMultiply(int num1, int num2) {
		int smaller = num1 < num2 ? num1 : num2;
		int bigger = num1 < num2 ?  num2 : num1;

		return multiplyHelper(smaller, bigger);
	}
	
	public static int multiplyHelper(int smaller, int bigger) {
		if(smaller == 0) return 0;
		else if(smaller == 1) return bigger;
		
		int s = smaller >> 1;    // divide by 2
		int side1 = multiplyHelper(s, bigger);
		if(smaller %2 ==0)
			return side1 + side1;
		else
			return side1 + side1 + bigger;
		
	}
	
	
}
