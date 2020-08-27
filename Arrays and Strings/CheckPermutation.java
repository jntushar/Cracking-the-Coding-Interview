/*
 * Question 1.2
 * 
 * Given two strings, write a method to decide if one is permutation of other.
 * */

package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckPermutation {

	static Set<String> set=new HashSet<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		
		allPermutations(str1, 0, str1.length()-1);
		if(set.contains(str2))
			System.out.println("It is permutation");
		else
			System.out.println("It is not Permutation");
		
		System.out.println(isPermutation(str1, str2));
	}
	
	static void allPermutations(String str, int l, int r) {
		if(l==r) {
			if(set.contains(str)) return;
			set.add(str);
			return;
		}
		for(int i=l; i<=r; i++) {
			str=interchange(str, l, i);
			allPermutations(str, l+1, r);
			str=interchange(str, l, i);
		}		
	}
	
	static String interchange(String str, int a, int b) {
		char array[] = str.toCharArray();
		char temp=array[a];
		array[a]=array[b];
		array[b]=temp;
		return String.valueOf(array);
	}
	
	// better approach - CTCI
	static boolean isPermutation(String str1, String str2) {
		if(str1.length()!=str2.length())
			return false;
		char[] str1_array = str1.toCharArray();
		char[] str2_array = str2.toCharArray();
		
		Arrays.sort(str1_array);
		Arrays.sort(str2_array);
		
		return String.valueOf(str1_array).equals(String.valueOf(str2_array));
	}
}
