/*
 * Question 8.1
 * 
 * A child is running up a staircase with n steps and can hop either 1 step, 2 step, or 3 step at a time.
 * Implement a method to count how many possible ways the child can run up the stair.
 * 
 * */
package RecursionAndDynamicProgramming;

import java.util.Scanner;

public class TripleStep {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n+1];
		System.out.println(getPossibleWays(n, dp));
		
		for(int i=0;i<dp.length;i++)
			System.out.println(dp[i] + " ");
		
	}
	
	public static int getPossibleWays(int n, int[] dp) {
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		
		dp[0] = 1;
		for(int i=1; i<=n; i++) {
			
			if(i==1) {
				dp[i]=dp[i-1];
			}else if(i==2) {
				dp[i]=dp[i-1] + dp[i-2];
			}else {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			
		}
		
		return dp[n];
	}

}


















