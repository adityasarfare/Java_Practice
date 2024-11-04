package com.demo;

public class BinarySearch {

	
	public static void main(String[] args) {
		
		
		int arr []= {1,2,3,4,5,66,78};
		int target= 5;
		int s =0;
		int e = arr.length-1;
		System.out.println(binarySearch(arr, target, s, e));
		
	}
	
	static int binarySearch(int[] arr, int target, int s, int e) {
		
		if( s >e ) {
			return -1;
		}
		
	    int m = s+ (e-s)/2;
	    
	    if(arr[m] == target) {
	    	return m;
	    }
	    else if (arr[m] < target) {
	    return	binarySearch(arr, target, m+1, e);
	    }
	    else {
	    	return binarySearch(arr, target, s, m-1 );
	    }
		
	}
}
