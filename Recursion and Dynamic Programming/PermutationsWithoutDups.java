/*
 * Question 8.7
 * 
 * Write a method to compute all permutations of a string of unique characters.
 * */
package RecursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Set;


public class PermutationsWithoutDups {

	static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) {

		permutationsWithoutDups("abcc", 0, 3);
	}

	public static void permutationsWithoutDups(String s, int l, int r) {
		if(l == r) {
			if(set.contains(s))
				return;
			set.add(s);
			System.out.println(s);
			return;
		}
		
		for(int i = l; i<=r; i++) {
			s = interchange(s, l, i);
			permutationsWithoutDups(s, l+1, r);
			s = interchange(s, l, i);
 		}
		
	}
	
	public static String interchange(String s, int i, int j) {
		char[] arr = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
	
}
