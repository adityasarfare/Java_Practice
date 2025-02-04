package com.demo.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapCollection {

	
	
	public static void main(String args[]) {
		
		Map<Integer, String> mp = new ConcurrentHashMap<>();
		
		mp.put(1, "aditya");
		mp.put(2,  "raju");
		mp.put(3, "manish");
		mp.put(4, "raghu");
		
//		System.out.println(mp);
		
		
		
		Set s =  mp.entrySet();
		Iterator r = s.iterator();
		
		while(r.hasNext()) {
		 Map.Entry e = 	(Map.Entry) r.next();
		 
		 System.out.println(e.getKey() + " " + e.getValue());
		 
         mp.put(5, "manu");
         mp.remove(4);
		}	
		System.out.println(mp.get(2));
		
		
//		Map<Integer, String> fm =  (Map<Integer, String>) mp.entrySet().stream().
//				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//		
		
		
//		for (Map.Entry<Integer, String> me : mp.entrySet()) {
//			
//			System.out.println(me.getKey() + " " + me.getValue());
//			
//			mp.put(5, "raj");
//			mp.remove(3);
//		}
	
	}

}
