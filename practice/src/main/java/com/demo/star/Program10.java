package com.demo.star;

public class Program10 {

	public static void main(String[] args) {
          for(int i =1; i<=4; i++) {
			
        	for(int k =2; k<=i; k++) {
  				System.out.print(" ");
  			}
			for(int j =4; j>=i; j--) {
				System.out.print("*");
			}
			
			for(int l=3 ; l>=i; l--) {
				System.out.print("*");	
			}
			
			for(int m = 2; m<=i; m++) {
				System.out.print(" ");
			}
			
//			for(int l = 2; l<=i; l++) {
//			System.out.print("*");	
//			}
			System.out.println();
			}
			
	}
}
