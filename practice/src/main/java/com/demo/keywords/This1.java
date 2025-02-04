package com.demo.keywords;

public class This1 {

	
	int id =1;
	
	int age;
	
    int show ()  {	
    	System.out.println("show " + id);
    	System.out.println(age);
    	return id;
    }
    
    void display(){	
    	show();
    }
    
    This1(){};
    
    This1(int age){
    	this();
    	this.age = age;
    };
    
    public static void main(String[] args) {
		
    	This1 t = new This1(35);
    	
    	t.show();
	}
}

