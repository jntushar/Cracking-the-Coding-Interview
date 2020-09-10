/*
 *Question 8.4
 *
 * Write a method to return all subset of a set.
 * 
 * */


package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(5);
		set.add(6);
		System.out.println(getPowerSet(set, 0));
	}
	
	public static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index) {      //Base Case
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			allsubsets = getPowerSet(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		
		return allsubsets;
	}

}
