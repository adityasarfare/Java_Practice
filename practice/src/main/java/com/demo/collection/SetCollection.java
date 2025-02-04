package com.demo.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetCollection {

	public static void main(String args[]) {
		
//		HashSet st = new HashSet<>();
//		st.add(11);
//		st.add(33);
//		st.add(33);
//		st.add(null);
//		st.add(null);
//		
//	System.out.println(st);
//		st.stream().forEach(x-> System.out.println(x));
//	
		
		LinkedHashSet ls = new LinkedHashSet<>();
		ls.add(11);
		ls.add(22);
		ls.add(33);
		ls.add(44);
		
		System.out.println(ls);
		
	}

	
}
