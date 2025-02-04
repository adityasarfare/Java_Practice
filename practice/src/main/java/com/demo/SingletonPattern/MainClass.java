
package com.demo.SingletonPattern;

public class MainClass {

	
	public static void main(String[] args) {
		
		SingletonClass s = SingletonClass.getInstance();
		s.simpleMethod();
		
		SingletonClass s1 = SingletonClass.getInstance();
		s1.simpleMethod();
	}
}
