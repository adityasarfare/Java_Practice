package com.demo;

import com.demo.Miscellanious.AccessModifier;

public class ClassD  {

	static int a = 5;
	
	int b = 4;
	
	public static void show() {
		System.out.println("Hello");
	}
	
	public ClassD() {
		super();
	}
	
	public static void main(String args[]) {
		
//		ClassD d = new ClassD();
		show();
		System.out.println(a);
	}

}
