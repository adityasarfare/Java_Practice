package com.demo.String;

public class RemoveChar {

	public static void main(String[] args) {
		
		removeChar("", "baccadh");
		
		System.out.println(removeCharWithReturnVal("baccadh"));
	}
	
	
	static void removeChar(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return ;
		}
		
		char c= up.charAt(0);
		
		if(c =='a') {
			removeChar(p, up.substring(1));
		}
		else {
			removeChar(p + c, up.substring(1));
		}
	}
	
	static String removeCharWithReturnVal( String up) {
		if(up.isEmpty()) {
			
			return "" ;
		}
		
		char c = up.charAt(0);
		
		if(c =='a') {
			return removeCharWithReturnVal(up.substring(1));
		}
		else {
		return c + removeCharWithReturnVal(up.substring(1));
		}
	}
}
