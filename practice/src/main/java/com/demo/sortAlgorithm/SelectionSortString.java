package com.demo.sortAlgorithm;

public class SelectionSortString {
  
	
	public static void main(String[] args) {
		
		String[] a = {"raj","manu","shubham","shruti","aditya"};
		
		int min; 
		String temp;
		for(int i=0; i<a.length; i++ ) {
			
			min=i;
		  for(int j=i+1; j<a.length; j++) {
			  
			  if(a[j].compareTo(a[min])<0) {
				  
				  min=j;
			  } 
		  }
		  temp=a[i];
		  a[i]=a[min];
		  a[min] = temp;
		 
			
		}
		 for(String s : a) {
			  System.out.print(s+ " ");
		  }
	}
}
