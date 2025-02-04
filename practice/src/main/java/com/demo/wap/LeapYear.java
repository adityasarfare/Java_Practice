package com.demo.wap;

public class LeapYear {
	
	
 public static void main(String[] args) {
	
	 int year = 2013;
	 
	 if(year%4==0) {
		 
		if (year%100==0) {
			
			
			if(year%400 ==0) {
				System.out.println("leap year");
			}else {
				System.out.println("not a leap year");
			}
		} else {
			System.out.println("leap year");
		}
		 
	 }
	 else {
		 System.out.println("not a leap year");
	 }
	 
}
}
