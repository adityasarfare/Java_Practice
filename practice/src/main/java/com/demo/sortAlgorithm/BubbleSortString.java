package com.demo.sortAlgorithm;

public class BubbleSortString {

	
	public static void main(String[] args) {
		
		String[] a = {"raj","manu","shubham","shruti","aditya"};
		
		for(int i=0; i< a.length; i++) {
			String temp;
			int count =0; 
			for(int j=0; j<a.length-1-i; j++) {
				
				if(a[j].compareTo(a[j+1])>0) {
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
		for(String s : a) {
			System.out.print(s+ " ");
			}
		
	}
}
