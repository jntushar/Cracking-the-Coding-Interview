/*
 * Question 1.1
 * 
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * */

package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Scanner;

public class IsUnique {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		if(isUnique(str))
			System.out.println("All characters are unique");
		else
			System.out.println("All characters are not unique");
		
		if(isUniqueChars(str))
			System.out.println("All characters are unique");
		else
			System.out.println("All characters are not unique");
	}
	
	// Using additional data structure ArrayList
	static boolean isUnique(String s) {
		char strArray[] = s.toCharArray();
		ArrayList<Character> uniqueChars= new ArrayList<>();
		for(int i=0; i<strArray.length; i++) {
			if(uniqueChars.contains(strArray[i]))
				return false;
			uniqueChars.add(strArray[i]);
		}
		return true;
	}
	
	// Without using additional data structure
	static boolean isUniqueChars(String s) {
		int check=0;
		for(int i=0; i< s.length(); i++) {
			int value = s.charAt(i) - 'a';
			if((check & (1 << value)) > 0) {
				return false;
			}
			check |= (1<<value);
		}
		return true;
	}

}
