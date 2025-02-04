package com.demo.Miscellanious;

public class InnerClass {

	int number = 3;
	
	void show() {
		System.out.println("Inside Show");
		
		
		class InnerClassA{
			
			int number = 3;
				
				void Display() {
					System.out.println("Inside Display");
				}
			}
		
		InnerClassA as = new InnerClassA();
		as.Display();
	}
	
	
	
	public static void main(String args[]) {
		
		InnerClass in = new InnerClass();
		
//		InnerClass.InnerClassA an = in.new InnerClassA();
//		an.Display();
		
//		InnerClass.InnerClassA an = new InnerClass.InnerClassA();
		
		in.show();
		
	}

	  
}


  
