package com.demo.Miscellanious;


public class CloneableExmple implements Cloneable {
       
	String name;
	int id;
	public CloneableExmple(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	public static void main(String args[]) {
		
		CloneableExmple ce = new CloneableExmple("Raj", 1);
		
		try {
			CloneableExmple copy =  (CloneableExmple) ce.clone();
			System.out.println(copy.id + copy.name);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
}
