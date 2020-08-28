/*
 * Question 1.9
 * 
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2,
 * write code to check if s2 is a rotation of s1 using only call to isSubstring(e.g.,"Waterbottle" is a rotation of erbottlewat).
 * 
 * */

package ArraysAndStrings;

import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		if(isRotation(s1.toLowerCase(), s2.toLowerCase()))
			System.out.println("True");
		else
			System.out.println("False");
	}

	static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		int i;
		for(i=0; i<s1.length(); i++) {
			if(s1.charAt(0) == s2.charAt(i))
				break;
		}
		
		for(int j=0; j<s1.length(); j++) {
			if(i<s2.length()) {
				if(s1.charAt(j) == s2.charAt(i))
					i++;
				else
					return false;
			}
			else {
				i=0;
				j--;
			}
		}
		return true;
	}
}
