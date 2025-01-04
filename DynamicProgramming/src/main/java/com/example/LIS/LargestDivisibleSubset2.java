package com.example.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset2 {

	
	public static void main(String[] args) {
		int [] nums  = {1, 16, 7, 8, 4};
		
		LargestDivisibleSubset2 l = new LargestDivisibleSubset2();
		List<Integer> ans = l.largestDivisibleSubset(nums);
		
	System.out.println(ans);
	}
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
        
		int n= nums.length;
		
		List<Integer> arr = new ArrayList<>();
		for(int num : nums) {
			arr.add(num);
		}
		Collections.sort(arr);
		
		List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
		List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));
		
		for(int i=0; i<n; i++) {
			hash.set(i, i);
			
			for(int prev =0; prev<=i-1; prev ++) {
				if(arr.get(i)%arr.get(prev) ==0 && 1+dp.get(prev) > dp.get(i)) {
					dp.set(i, 1+dp.get(prev));
					hash.set(i, prev);
				}
			}
		}
		
		int ans =-1;
		int lastIndex =-1;
		
		
		
		for(int i=0; i<n; i++) {
			if(dp.get(i) > ans) {
				ans = dp.get(i);
				lastIndex=i;
			}
		}
		
		List<Integer> temp = new ArrayList<>();
		
		temp.add(arr.get(lastIndex));
		
		
		while(hash.get(lastIndex) != lastIndex) {
			lastIndex = hash.get(lastIndex);
			temp.add(arr.get(lastIndex));
		}
		Collections.reverse(temp);
		return temp;
    }
	
}
