package com.example.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum3 {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		
	    //-4,-1,-1,0,1,2
		for(int i=0; i< nums.length; i++) {
			if(nums[i]>0) {
				break;
			}
			
			if(i>0 && nums[i]== nums[i-1]) {
				continue;
			}
			
			int li =i+1;
			int hi =nums.length-1;
			
			
			while(li<=hi) {
				int sum = nums[i] + nums[li] + nums[hi];
				
				if(sum>0) {
					hi--;
				}else if (sum<0) {
					li++;
				}else {
					if(sum ==0) {
						res.add(Arrays.asList(nums[i], nums[li], nums[hi]));
						li++;
						hi--;
						
						while(li<hi && nums[li] == nums[li-1]) {
							li++;
						}
					}
					
					
				}
			}
		}
		return res;
	}
}

