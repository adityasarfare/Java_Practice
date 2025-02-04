package com.demo.Java8;

public interface Vehicle {

	
	default void show() {
		System.out.println("In a motor");
	}
	
	static void blowHorn() {
		System.out.println("Im in a vehicle");
	}
}
