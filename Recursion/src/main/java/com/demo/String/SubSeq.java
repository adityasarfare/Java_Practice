package com.demo.String;

import java.util.ArrayList;

public class SubSeq {

	public static void main(String[] args) {
		
//		removeChar("", "baccadh");
		
		subSeq("", "abc");
		
		System.out.println(subSeqReturnArrayList("", "abc"));
	}
	
	
	static void subSeq(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return ;
		}
		
		char c= up.charAt(0);
		
	
			subSeq(p, up.substring(1));
			subSeq(p + c, up.substring(1));
	}
	
	static ArrayList<String> subSeqReturnArrayList(String p, String up) {
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(p);
			return list ;
		}
		
		char c= up.charAt(0);
		
	
		ArrayList<String> left=	subSeqReturnArrayList(p+c, up.substring(1));
		ArrayList<String> right= subSeqReturnArrayList(p, up.substring(1));
		
		left.addAll(right);
		return left;
	}
	
}
