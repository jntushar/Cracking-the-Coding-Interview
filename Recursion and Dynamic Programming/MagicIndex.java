/*
 * Question 8.3
 * 
 * A magic index in an array A[0...n-1] is defined to be an index such the A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * 
 * FOLLOW UP
 * 
 * What if the values are not distinct?
 * 
 * */

package RecursionAndDynamicProgramming;

public class MagicIndex {

	public static void main(String[] args) {
		int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		System.out.println(getMagicIndex(arr, 0, arr.length-1));
	}
	
	public static int getMagicIndex(int[] arr, int start, int end) {
		if(end<start)
			return -1;
		
		int mid = (start+end)/2;
		if(arr[mid] == mid)
			return mid;
		else if(arr[mid] > mid)
			return getMagicIndex(arr, start, mid-1);
		else
			return getMagicIndex(arr, mid + 1, end);
		
	}

}
