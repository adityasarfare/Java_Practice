package com.demo.prototypePattern;

public abstract class  Profession implements Cloneable{

	
	public int id;
	public String name;
	
	abstract void print();
	
	public Object cloningMethod() throws CloneNotSupportedException  {
		
		try {
			Object clone = super.clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone();
		
	}
	
}
