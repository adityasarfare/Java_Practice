package com.demo.solution;

public class Solution {

	
	int[] a = new int[5];
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.a[0]=12;
		s.a[1]=45;
		s.a[2]=66;
		s.a[3]=70;
		
		int[] n =s.insert(99);
		
		for(int ans : n ) {
			System.out.println(ans);
		}
		
	
	}
	
	public  int[] insert(int value) {
		int temp;
		for(int i = a.length-2; i>=0; i--) {
			if(i == 1)
			{
			temp= a[i];
		    a[i+1]= temp;
			a[i]= value;
			break;
			}
			else {
		   temp= a[i];
		   a[i+1]= temp;
			}
		}
		return a;
	}
}
