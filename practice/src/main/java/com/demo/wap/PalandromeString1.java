package com.demo.wap;

public class PalandromeString1 {

	
	public static void main(String[] args) {
		String g = "nitin";
		String temp = g;
		String r = "";
		for(int i=temp.length()-1; i>=0; i--) {
			r = r + temp.charAt(i);
		}
		System.out.println(r);
		
		if(g.equals(r)) {
			
			System.out.println("Is palndrome");
		}
		else {
			System.out.println("Not a palandrome");
		}
	}
}
