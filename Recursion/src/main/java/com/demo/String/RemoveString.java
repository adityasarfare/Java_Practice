package com.demo.String;

public class RemoveString {

	public static void main(String[] args) {
		
	
		
//		System.out.println(removeString("baccappledh"));
		System.out.println(removeAppNotApple("bappccappledh"));

	}
	
	static String removeString( String up) {
		if(up.isEmpty()) {
			return "" ;
		}
		
		if(up.startsWith("apple")) {
			return removeString(up.substring(5));
		}
		else {
		return up.charAt(0) + removeString(up.substring(1));
		}
	}
	
	static String removeAppNotApple( String up) {
		if(up.isEmpty()) {
			return "" ;
		}
		
		
		
		if(up.startsWith("app") && !up.startsWith("apple")) {
			return removeAppNotApple(up.substring(3));
		}
		else {
		return up.charAt(0) + removeAppNotApple(up.substring(1));
		}
	}
}
