package com.demo.keywords;

public class Super2 extends Super1 {

	
	int id =200;
	
	int age;
	
	
	Super2(){};
	
	Super2(int age){
		
		super();
		this.age = age;
	}
	
	void show1() {
		super.show();
	    System.out.println(super.id);
	    System.out.println(this.id);
		System.out.println("show");
	}
    
    public static void main(String[] args) {
		
    	Super2 t = new Super2(6);
    	t.show1();
    	
	}
}

