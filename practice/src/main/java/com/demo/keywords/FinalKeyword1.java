package com.demo.keywords;

public  class FinalKeyword1 {

	
	public final int a= 10;
	
	
	public final void show(int a) {
		
		System.out.println(this.a);
	}
	
	public static void main(String[] args) {
		
		FinalKeyword1 f = new FinalKeyword1();
		
		f.show(4);
	}
}
