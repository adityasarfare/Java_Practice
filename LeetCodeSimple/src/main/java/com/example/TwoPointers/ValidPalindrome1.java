package com.example.TwoPointers;

public class ValidPalindrome1 {

	public boolean isPalindrome(String s) {
		
		String str = s.toLowerCase();
		char[] ch= str.toCharArray();
		
		
		int li =0;
		int hi = ch.length-1;
		
		
		while(li<=hi) {
			if(!Character.isLetterOrDigit(ch[li])) {
				li++;
			}else if (!Character.isLetterOrDigit(ch[hi])) {
				hi++;
			}else {
				if(ch[li] != ch[hi]) {
					return false;
				}
				li++;
				hi--;
			}
			
		}
		
		return true;
	}
}
