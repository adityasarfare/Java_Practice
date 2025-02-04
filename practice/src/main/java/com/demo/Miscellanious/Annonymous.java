package com.demo.Miscellanious;

public class Annonymous {

	
	
	public static void main(String args[]) {
		AnnoymousExample an = new AnnoymousExample() {
			
			public void show () {
				
				System.out.println("inside show");
			}
		
		
      
		
		
		};
		an.show();
		}

	
}


class AnnoymousExample{
	public void show () {
		
		System.out.println("inside show");
	}

	
}