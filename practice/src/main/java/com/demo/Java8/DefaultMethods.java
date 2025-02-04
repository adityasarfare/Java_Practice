package com.demo.Java8;

import java.util.List;

public class DefaultMethods implements Vehicle {

	public void display() {
		System.out.println("In a car");
		Vehicle.super.show();
		Vehicle.blowHorn();
	}
	
	public static void main(String args[]) {
		
	
		DefaultMethods dm = new DefaultMethods();
		dm.display();
        
	}
}
