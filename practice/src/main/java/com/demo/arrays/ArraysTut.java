package com.demo.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysTut {

	
	public static void main(String args[]) {
		int [][][] a = {{{1,2,3},{4,5,6}, {7,8,9}}};
//		System.out.println(a[0][1][1]);
		System.out.println(a.length);
		
//		
//		for(int i =0; i<a.length; i++ ) {
//			for (int j=0; j<a[i].length; j++) {
//				for( int k=0; k< a[i][j].length; k++) {
//				  System.out.println(a[i][j][k]);
//				}
//			}
//		}
//	    
		
//		Arrays.stream(a).flatMapToInt(Arrays::stream).boxed().forEach(x -> System.out.println(x));
	}

}
