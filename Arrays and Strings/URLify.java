/*
 * Question 1.3
 * 
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end 
 * to hold the additional characters, and that you are given the "true" length of the string.(Note: If implementing in Java,
 * please use a character array so that you can perform this operation in place.)
 * 
 * Example
 * 
 * Input: "Mr John Smith    ", 13
 * Output: Mr%20John%20Smith
 * */

package ArraysAndStrings;

import java.util.Scanner;

public class URLify {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s=scanner.nextLine();
		int len=scanner.nextInt();
		int spaces=0;
		char[] arr=s.toCharArray();
		for(int i=0; i<len; i++) {
			if(arr[i]==' ')
				spaces++;
		}
		
		char[] newString = new char[len + spaces*2];
		int j=0;
		for(int i=0; i<len; i++) {
			if(arr[i]==' ') {
				newString[j]='%';
				newString[++j]='2';
				newString[++j]='0';
			}
			else
				newString[j]=arr[i];
				j+=1;
		}
		
		System.out.println(String.valueOf(newString));
	}

}
