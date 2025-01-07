package com.example.dpSquares;

import java.util.Stack;

public class MaximalRectangle1 {
	public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };
        
        
       int ans =  maximalRectangle(mat);
       System.out.println(ans);
}

	
	private static int maximalRectangle(int[][] mat) {
		
		int n= mat.length;
		int m = mat[0].length;
		
		int [] height = new int[m];
		
		int maxArea =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(mat[i][j] ==1) {
					height[j]++;
				}else {
					height[j]=0;
				}
			}
			int area = largestArea(height);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}


	private static int largestArea(int[] height) {
		int n= height.length;
		Stack<Integer> st = new Stack<>();
		
		int mArea =0;
		
		for(int i=0; i<=n; i++) {
			
			while(!st.isEmpty() && (i==n || height[st.peek()]>=height[i])) {
				int h = height[st.peek()];
				st.pop();
				int width;
				if(st.isEmpty()) {
					width =i;
				}
				else {
					width = i-st.peek()-1;
				}
				mArea = Math.max(mArea, h * width);
			}
			st.push(i);
		}
		return mArea;
	}
}