package com.demo.SingletonPattern;

public class SingletonClass {
	
	private  static volatile SingletonClass sc;
	
	private SingletonClass() {
		if(sc != null) {
			throw new RuntimeException("Singleton already created");
		}
		System.out.println("Singleton instance created");
	}
	
	public Object readResolve() {
		return sc;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();	
	}
	
	public static SingletonClass getInstance() {
		if(sc ==null) {
			
			synchronized (SingletonClass.class) {
				if(sc == null) {
					sc = new SingletonClass();
				}
			}
		}
		
		return sc;
	}
	
	public void simpleMethod() {
		System.out.println("hashcode of singleton object" + sc);
	}

}
