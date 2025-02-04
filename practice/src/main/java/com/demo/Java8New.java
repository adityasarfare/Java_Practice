package com.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Java8New implements Java8demo{

	@Override
	public void show() {
		System.out.println("Hii");
		
	}

	@Override
	public void show1() {
		// TODO Auto-generated method stub
		
	}
	
	
  public static void main(String[] args) {
	  ArrayList<Integer> al = new ArrayList<>();
	   al.add(1);
	   al.add(2);
	   al.add(3);
	   al.add(4);
	   
//	  Iterator<Integer> a =  al.iterator();
//	  while(a.hasNext()) {
//		  System.out.println(a.next());
//	  }
	   
	   al.forEach(x-> System.out.println(x));   
  }
}
