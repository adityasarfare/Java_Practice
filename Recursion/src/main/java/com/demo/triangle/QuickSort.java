package com.demo.triangle;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] num = {5,4,3,2,1};
		 sort(num, 0, num.length-1);
		 System.out.println(Arrays.toString(num));
	}
	
	
	static void sort(int [] num, int low, int hi) {
		
		if(low>= hi) {
			return;
			}
		
		int s=low;
		int e=hi;
		int pivot= s+(e-s)/2;
		
		while(s<=e) {
			while(num[s]< num[pivot]) {
				s++;
			}
			
			while(num[e]> num[pivot]) {
				e--;
			}
			
			if(s<=e) {
				int temp= num[s];
				num[s] = num[e];
				num[e] = temp;
				s++;
				e--;
			}
		}
		sort(num, s, hi);
		sort(num, low, e);
		
		
	}
}
