package com.demo.Miscellanious;

public class Auto_BoxingnAuto_UnBoxing {

	
	public static void main(String args[]) {
		
		int num = 7;
		
		Integer  num1 = num; // AutoBoxing
		
		System.out.println(num1);
		
		
	  Integer num2 = 4;
	  
	  int num3 = num2; // Auto-Unboxing
	  
	  System.out.println(num3);
	  
	  
	  String s = "65";
	  
	  int a = Integer.parseInt(s);
	  System.out.println(a);
	}

}
