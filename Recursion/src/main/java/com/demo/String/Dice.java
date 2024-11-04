package com.demo.String;

import java.util.ArrayList;

public class Dice {

	
	public static void main(String[] args) {
		
		
//		dicethrow("", 4);
		System.out.println(dicethrowArray("", 4));
	}
	
	static void dicethrow(String p, int target) {
		
		if(target==0) {
			System.out.println(p);
			return ;
		}
		
		for(int i=1; i<=6 && i<=target; i++) {
			dicethrow(p+i, target-i);
		}
		
	}
	
   static ArrayList<String> dicethrowArray(String p, int target) {
		
   if(target==0) {
        ArrayList<String> list = new ArrayList<>();
          list.add(p);
			return list ;
		}
		
	ArrayList<String> list = new ArrayList<>();
		for(int i=1; i<=6 && i<=target; i++) {
			
		list.addAll(dicethrowArray(p+i, target-i));
		}
		return list;
		
	}
}
