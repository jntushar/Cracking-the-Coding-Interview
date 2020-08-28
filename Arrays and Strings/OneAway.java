/*
 * Question 1.5
 * 
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or
 * replace a character. Given two strings, write a function to check if they are one edit(or zero edits) away.
 * 
 * */
package ArraysAndStrings;

import java.util.Scanner;

public class OneAway {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1=scanner.nextLine();
		String str2=scanner.nextLine();
		if(isOneAway(str1, str2))
			System.out.println("True");
		else
			System.out.println("False");
	}
	
	static boolean isOneAway(String str1, String str2) {
		//if difference of length is more than one, they can't be one edit away
		int str1_len=str1.length();
		int str2_len=str2.length();
		
		if(Math.abs(str1_len - str2_len)>1)
			return false;
		
		//to check zero edits
		if(str1.equals(str2)) return true;
		
		int edits=0;
		if(str1_len==str2_len) {
			//for replace, 
			for(int i=0; i<str2_len; i++) {
				if(str1.charAt(i) != str2.charAt(i))
					edits++;
			}
		}
		else {
			if(str1_len + 1 == str2_len)
				edits = insertOrRemove(str1, str2, edits);
			else
				edits = insertOrRemove(str2, str1, edits);
		}
		return edits<2;
	}
	
	static int insertOrRemove(String str1, String str2, int edits) {
		int index1=0;
		int index2=0;
		while(index1 < str1.length() && index2 < str2.length()) {
			if(str1.charAt(index1) != str2.charAt(index2)) {
				index2++;
				edits++;
			}else {
				index1++;
				index2++;
			}
		}
		return edits;
	}
	
}












