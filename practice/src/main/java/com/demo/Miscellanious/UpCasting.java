package com.demo.Miscellanious;

public class UpCasting {

	public static void main(String args[]) {
	 
	Animal an = new CastingExample();
	
	UpCasting.doanmialStuff(an);
	}

	
	public static void doanmialStuff( Animal ce) {
		
		
		ce.makenoise();
	}
	
}
