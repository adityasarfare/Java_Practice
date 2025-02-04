package com.demo.inheritence;

public class MultipleInheritence3 implements MultipleInheritence1, MultipleInheritence2 {


	public void print_for() {
		// TODO Auto-generated method stub
		System.out.println("for");
	}

	
	public void print_geek() {
		// TODO Auto-generated method stub
		System.out.println("geek");
	}
	
	public static void main(String[] args) {
		
		MultipleInheritence3 m3 = new MultipleInheritence3();
		
		m3.print_geek();
		m3.print_for();
		m3.print_geek();
	}

	
	
	
}
