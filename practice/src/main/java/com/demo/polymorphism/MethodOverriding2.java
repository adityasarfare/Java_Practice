package com.demo.polymorphism;

public class MethodOverriding2 extends MethodOverriding1 {

	public void show() { System.out.println("Child's show()"); }
	
	
	public static void main(String[] args) {
		
		MethodOverriding1 a = new MethodOverriding1();
		
		a.show();
		
        MethodOverriding2 b = new MethodOverriding2();
		
		b.show();
	}
}
