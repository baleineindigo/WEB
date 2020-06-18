package  algorithm01;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		HashMap<Integer,Integer> bangs = new HashMap<Integer,Integer>();
		bangs.put(1,11);
		bangs.put(2, 22);
		System.out.println(bangs);
		System.out.println(bangs.remove(1, 11));
		System.out.println(bangs);
	}//main	
}//class