package com.demo.String;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		
//		permutionString("", "abc");
		ArrayList<String>  n = permutionStringList("", "abc");
		System.out.println(n);
	}
	
	static void permutionString(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return ;
		}
		
		char ch= up.charAt(0);
		
//		_a_ -->bc
//		  
		
		for(int i=0; i<= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i);
			
			permutionString(first + ch + second , up.substring(1));
		}
		
		
	}
	
	static ArrayList<String> permutionStringList(String p, String up) {
		if(up.isEmpty()) {

         ArrayList<String> list = new ArrayList<String>();
           list.add(p);
			return list ;
		}
		
		char ch= up.charAt(0);
		
		ArrayList<String> ans = new ArrayList<String>();
		
		for(int i=0; i<= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i);
			ans.addAll(permutionStringList(first + ch + second , up.substring(1)));
		}
		  return ans;
		
	}
}
