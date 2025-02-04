package com.demo.sortAlgorithm;

public class BubbleSort {

	
	public static void main(String[] args) {
		
		int[] a = {19,36,29,12,5};
		
		for(int i=0; i< a.length; i++) {
			int temp;
			int count =0; 
			for(int j=0; j<a.length-1-i; j++) {
				
				if(a[j] > a[j+1]) {
				temp=a[j];
				a[j]= a[j+1];
				a[j+1]= temp;
				count = count+1;	
				}
			}
			
			if(count==0) {
				break;
			}
			
		}
		for(int s : a) {
			System.out.print(s+ " ");
			}
		
	}
}
