package com.demo.Miscellanious;

public class AccessModifier {

	protected String name = "Aditya";
	
	protected void show () {
		System.out.println("Im in show");
	}
	
	public AccessModifier() {
		System.out.println("Im in constructor");
	}
}
