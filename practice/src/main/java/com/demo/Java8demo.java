package com.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;

//@FunctionalInterface
public interface Java8demo {

	
	
	
      abstract void show ();
      
      void show1();
     
     default void display() {
    	 System.out.println("hello display");
     }
     
     static void present() {
    	 System.out.println("inside static");
     }
     
     
     
     
}
