package com.demo.keywords;

public class Super1 {

	
	int id =1;
	
	int age;
	
    Super1(){};
    
    Super1(int age){
    	this();
    	this.age = age;
    	
    	System.out.println("This is super constructor");
    };
	
	void show() {
		
		System.out.println("show");
	}
    
    public static void main(String[] args) {
		
    	Super1 t = new Super1();
    	
    	
	}
}

