package com.demo.polymorphism;

public class MethodOverloading {

	
	void show() {
		
		System.out.println("1");
	}
	
	void show( int a) {
		System.out.println("2");
	}
	
//	public static void main(String[] args) {
//		
//		MethodOverloading mo = new MethodOverloading();
//		mo.show();
//		mo.show(1);
//	
////		main();
//	}
	
//      public static void main() {
//		
//		MethodOverloading mo = new MethodOverloading();
//		mo.show();
//		mo.show(1);
//	}
	
	
////////// Automatic promotion
	
//	void display (int a) {
//		System.out.println("int method");
//	}
//	
//	void display (String b) {
//		System.out.println("String method");
//	}
//	
//public static void main(String[] args) {
//		
//		MethodOverloading mo = new MethodOverloading();
//		mo.display('c');
//	
//
//	}
	
	
//	void display (Object a) {
//		System.out.println("int method");
//	}
//	
//	void display (String b) {
//		System.out.println("String method");
//	}
//	
//public static void main(String[] args) {
//		
//		MethodOverloading mo = new MethodOverloading();
//		mo.display('c');
//	
//
//	}
	

////////// var args	
	void display (int a) {
		System.out.println("int method");
	}
	
	void display (int ... b) {
		System.out.println("String method");
	}
	
public static void main(String[] args) {
		
		MethodOverloading mo = new MethodOverloading();
		mo.display(5,6,3);
	

	}
}
