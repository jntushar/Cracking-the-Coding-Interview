/*
 * Question 8.6
 * 
 * In the classic problem of Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower.
 * The puzzle starts with sorted in ascending order of size from top to bottom (i.e., each disks sits on top of an even larger one).
 * You have the following constraints:
 * 
 * (1) Only one disk can be moved at a time.
 * 
 * (2) A disk is slid off the top of one tower onto another tower.
 * 
 * (3) A disk cannot be placed on top of a smaller disk.
 * 
 * Write a program to move the disks from tower to the last using stacks.
 * 
 * */

package RecursionAndDynamicProgramming;

public class TowersOfHanoi {

	public static void main(String[] args) {
		char source = 'A';
		char destination = 'C';
		char helper = 'B';
		towersOfHanoi(3, source, destination, helper);

	}

	public static void towersOfHanoi(int n, char source, char destination, char helper) {
		if(n == 0)
			return;
		
		towersOfHanoi(n-1, source, helper, destination);  
		System.out.println(n + "[" + source + "->" + destination + "]");
		towersOfHanoi(n-1, helper, destination, source);
	}
}
