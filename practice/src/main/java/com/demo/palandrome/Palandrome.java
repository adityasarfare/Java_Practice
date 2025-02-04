package com.demo.palandrome;

public class Palandrome {
	static String original = "Hello World!";
	
	public static String palandrome(String str) {
		
	char[] ch = str.toCharArray();
		
		for(int i=0, j = ch.length-1; i<j ; i++, j-- ) {
			
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			
			 synchronized (ch) {
		            for (int k = 0; k < ch.length; k++) {
		                System.out.println(ch[k]);
		            }
		        }
			

		}
		
		return new String(ch);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String reverse = palandrome(original);
		
		System.out.println(original);
		System.out.println(reverse);
		
		
	}
	
	
}
