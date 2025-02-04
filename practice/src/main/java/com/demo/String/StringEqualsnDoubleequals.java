package com.demo.String;

public class StringEqualsnDoubleequals {

	public static void main(String args[]) {
		
		
		String s1 = new String("deepak");
		String s2 = new String("deepak");
		String s5 = new String("Raj");
		String s6 = s5.concat(" hero");
		
		System.out.println(s6);

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 = "amit";
		String s4 = "amit";
		
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
	}
	
}
