/*
 * Question 8.8
 * 
 * Write a method to compute all permutations of a string whose characters are not necessarily unique.
 * The list of permutations should not have duplicates.
 * */
package RecursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class PermutationsWithDuplicates {
	static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
		permutationWithDuplicates("abcc", 0, 3);
	}

	public static void permutationWithDuplicates(String s, int l, int r) {
		if(l == r) {
			if(set.contains(s))
				return;
			set.add(s);
			System.out.println(s);
			return;
		}
		
		for(int i = l; i<=r; i++) {
			s = interchange(s, l, i);
			permutationWithDuplicates(s, l+1, r);
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
