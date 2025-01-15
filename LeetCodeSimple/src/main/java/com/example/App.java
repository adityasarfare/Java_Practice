package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {

	 public List<List<Integer>> threeSum(int[] nums) {
		 Arrays.sort(nums);
		 
		 List<List<Integer>> res = new ArrayList<>();
		 for(int i=0; i<nums.length; i++) {
			 if(nums[i]>0) {
				 break;
			 }
			 if(i>0 && nums[i]==nums[i-1]) {
				 continue;
			 }
			 
			 int li =i+1;
			 int hi = nums.length -1;
			 
			 while(li<=hi) {
				 int sum = nums[i]+ nums[li] + nums[hi];
				 
				 if(sum<0) {
					 li++;
				 }
				 else if(sum>0) {
					 hi--;
				 }
				 else {
					 if(sum ==0) {
						res.add(Arrays.asList(nums[i], nums[li], nums[hi]));
						li++;
						hi--;
						
						while(li <hi && nums[i]==nums[i-1]) {
							li++;
						}
					 }
					 }
			 }
		 }
		 
		 return res;
	 }


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
