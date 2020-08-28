/*
 * Question 1.4
 * 
 * Given a string, write a function to check if it is permutation of a palindrome. A palindrome is a word or phrase that
 * is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited
 * to just dictionary words.
 * 
 * Example
 * 
 * Input: Tact Coa
 * Output: True
 * */

package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromePermutation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str=scanner.nextLine();
		if(isPalindromePermutation(str.toLowerCase()))
			System.out.println("True");
		else
			System.out.println("False");
	}
	
	static boolean isPalindromePermutation(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr=str.toCharArray();
		for(char c : arr) {
			if(map.containsKey(c)) {
				map.replace(c, map.get(c)+1);
			}
			else
				map.put(c, 1);
	}
		int count=0;
		for(char c: map.keySet()) {
			if(c==' ') continue;
			if(map.get(c)%2!=0)
				count++;
		}
		return count<2;
	}

}
