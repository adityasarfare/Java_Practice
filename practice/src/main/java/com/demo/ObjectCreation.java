package com.demo;

public class ObjectCreation {

	//----- Using Reference variable 
	
//	String  color;
//	
//	int age;
//	
//	public static void main(String[] args) {
//		
//		ObjectCreation ob = new ObjectCreation();
//		
//		ob.color= "red";
//		ob.age = 5;
//		
//		System.out.println(ob.color + " " + ob.age);
//	}
	
	//----- Using Method
	
//	String color ;
//	
//	int age;
//	
//	void initobj(String color, int age) {
//		
//		this.color = color;
//		this.age = age;
//	}
//	
//	
//	void display() {
//		
//		System.out.println(color + " "+ age );
//	}
//	
//	public static void main(String[] args) {
//		
//		ObjectCreation ob = new ObjectCreation();
//		
//		ob.initobj("red", 5);
//		
//		ob.display();
//	}
	
	//----- Using Constructor
	
		String color ;
		
		int age;
		
		public ObjectCreation(String color, int age) {
			
			this.color = color;
			this.age = age;
		}
		
		
		
		void display() {
			
			System.out.println(color + " "+ age );
		}
		
		public static void main(String[] args) {
			
			ObjectCreation ob = new ObjectCreation("red", 5);
			
			ob.display();
		}
	
}
