package com.demo;

public class FactoryMethodExample {

	
	public static FactoryMethodExample newInstancemethod() {
		
		return new FactoryMethodExample();
	}
	
	
	public static void main(String[] args) {
	FactoryMethodExample fm = FactoryMethodExample.newInstancemethod();

	System.out.println(fm);
	}
}
