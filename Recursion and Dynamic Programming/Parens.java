/*
 *Question 8.9
 *
 * Implement an algorithm to print all valid (i.e. properly opened and closed) combinations of n pairs of parenthesis.
 * 
 * EXAMPLE
 * Input : 3
 * Output : ((())), (()()), (())(), ()(()), ()()()
 * */

package RecursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static void main(String[] args) {
		System.out.println(getParens(3));

	}
	
	public static Set<String> getParens(int n){
		Set<String> parens = new HashSet<String>();
		if(n==0) {
			parens.add("");
		}
		else {
			Set<String> prev = getParens(n - 1);
			for(String str : prev) {
				for(int i = 0; i<str.length(); i++) {
					if(str.charAt(i) == '(') {
						String s = insertInside(str, i);
						parens.add(s);
					}
				}
				parens.add("()" + str);
			}
		}
		return parens;
	}

	public static String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1, str.length());
		return left + "()" + right;
	}
	
}

