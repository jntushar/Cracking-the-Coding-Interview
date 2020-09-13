/*
 * Question 8.11
 * 
 * Given an infinite number of quarters(25 cents), dimes(10 cents), nickels(5 cents), and pennies(1 cent),
 * write code to calculate the number of ways of representing n cents.  
 * */


package RecursionAndDynamicProgramming;

public class Coins {

	public static void main(String[] args) {
		System.out.println(makechanges(100));
	}

	public static int makechanges(int n) {
		int[] denoms = {25, 10, 5, 1};
		int[][] dp = new int[n + 1][denoms.length];
		return makechanges(n, denoms, 0, dp);
	}
	
	public static int makechanges(int amount, int[] denoms, int index, int[][] dp) {
		if(dp[amount][index] > 0) {
			return dp[amount][index];
		}
		if(index >= denoms.length-1) return 1;
		int ways = 0;
		int denomAmount = denoms[index];
		for(int i = 0; amount >= denomAmount*i ;i++) {
			int remainingAmount = amount - denomAmount*i;
			ways += makechanges(remainingAmount, denoms, index+1, dp);
		}
		
		dp[amount][index] = ways;
		return ways;
	}
	
}
