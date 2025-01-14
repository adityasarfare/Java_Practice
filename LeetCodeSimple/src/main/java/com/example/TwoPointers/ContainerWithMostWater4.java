package com.example.TwoPointers;

public class ContainerWithMostWater4 {
	public int maxArea(int[] heights) {
        int maxRes =0;
        int li=0;
        int hi=heights.length-1;

        while(li < hi){
            if(heights[li] < heights[hi]){
            maxRes= Math.max(maxRes, heights[li] * (hi-li));
               li++; 
            }else
            {
            maxRes= Math.max(maxRes, heights[hi] * (hi-li));
            hi--;
            }
        }
        return maxRes;
    }
}
