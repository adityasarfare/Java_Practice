package com.example.TwoPointers;

public class TwoIntegerSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int li =0;
		int hi = numbers.length-1;
		
		int [] res = new int[2];
		
		while(li<=hi) {
			int sum = numbers[li] + numbers[hi];
			
			if(sum == target) {
				res[0] = li+1;
				res[1] = hi+1;
			}else if(sum < target) {
				li++;
			}else {
				hi--;
			}
		}
		
		return res;
	}
}
