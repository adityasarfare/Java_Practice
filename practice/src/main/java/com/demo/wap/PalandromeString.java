package com.demo.wap;

public class PalandromeString {

	
	public static String reverse( String str) {
		
//		char[] ch = str.toCharArray();
//		
//		for(int i=0, j = ch.length-1; i<j ; i++, j-- ) {
//			
//			char temp = ch[i];
//			ch[i] = ch[j];
//			ch[j] = temp;
//		}
		String g = "";
		for(int i =str.length()-1; i>=0; i--) {
			g = g + str.charAt(i);
		}
		
		return g;
	}
	
	 public static boolean isPalindrome(String rev, String org ) {
	      
		 for(int i = rev.length()-1, j =0; i>=0 &&j<=org.length()-1; i--, j++) {
			 
			 if(rev.charAt(i)== org.charAt(j)) {
				 System.out.println("this is palandrome");
				 return true;
			 }
			 else {
				return false;
			 }
		 }
	        
		 
		 return false;
	    }
	
	
	public static void main(String[] args) {
		
		String Original="nitin";
		String Reverse = reverse(Original);
		
		System.out.println(Original + ":");
		System.out.println(Reverse + ":");
		
		
		 
		System.out.println(isPalindrome(Reverse, Original)); 
	}
}
