package com.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListCollection {

	public static void main(String args[]) {

//		int [] as = {1,3,5};

		List a = new ArrayList<>();
		a.add(2);
		a.add("Aditya");
		a.add('c');
		a.add("Rahul");

		Iterator al = a.iterator();

		while (al.hasNext()) {
			Object i = al.next();

			if (i == "Aditya") {
				al.remove();
			}

			System.out.println(al);
		}

//		a.stream().filter(x-> x!="Aditya").forEach(x -> System.out.println(x));

//		Lit al = new LinkedList<>();
//		al.add(2);
//		al.add("Aditya");
//		al.add('c');
//		al.add("sarfare");
//		
//		al.stream().forEach(x -> System.out.println(x));
//		
//	
//		al.stream().forEach(x -> System.out.println(x));

//		Stack stack = new Stack<>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);

//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		System.out.println(stack.search(1));
//        stack.stream().forEach(x-> System.out.println(x));

		List<Integer> a2 = new CopyOnWriteArrayList<>();
		a2.add(1);
		a2.add(2);
		a2.add(4);
		a2.add(5);
//		
//		
		Iterator<Integer> l = a2.iterator();
//		
		while (l.hasNext()) {
//			/Integer i = (Integer) l.next();
//		
//			System.out.println(i);
//			l.remove();

//			a.removeIf(s -> s.equals(2));
			System.out.print(l.next());
			a2.add(6);

			
		}

//	a.removeIf(i -> i.equals(1));

		// Use enhanced for loop to iterate
//        for (Integer i : a) {
//            System.out.println(i);
//		
//		
//		}
//		

//		
//		List aa = Arrays.asList(1,2,3,44);
//		
//		aa.stream().forEach(x -> System.out.println(x));
//		System.out.println(aa);

	}
}
