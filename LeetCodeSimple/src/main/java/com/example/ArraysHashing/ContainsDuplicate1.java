package com.example.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate1 {
	public boolean hasDuplicate(int[] nums) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int no : nums) {
			if(set.contains(no)) {
				return true;
			}
			
			set.add(no);
		}
		return false;
	}
}
