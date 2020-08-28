/*
 * Question 1.6
 * 
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. if the compressed string would not become smaller than the 
 * original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters(a-z).
 * 
 * */

package ArraysAndStrings;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(getCompressedString(str));
	}

	static String getCompressedString(String s) {
		String compressedString="";
		int count=0;
		for(int i=0; i<s.length(); i++) {
			if(count==0) {
				compressedString += s.charAt(i);
				count++;
			}
			else if(s.charAt(i)!=compressedString.charAt(compressedString.length()-1)) {
				compressedString += count;
				count=0;
				i--;
			}
			else
				count++;
		}
		compressedString += count;
		
		return compressedString.length() <= s.length() ? compressedString : s ;

	}
	
}
