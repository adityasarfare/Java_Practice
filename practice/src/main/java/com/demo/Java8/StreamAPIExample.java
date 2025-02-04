package com.demo.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExample {

	
	public static void main(String args[]) {
	//============================================================	
		Stream.of(1,2,3,4,5,6).forEach(System.out::println);
	//================================================================	
		String[] name = {"code", "decode", "concept"};
		
		Stream.of(name).forEach(s-> System.out.println(s));
	//=================================================================
	  //MAP	
	List<Integer> map = Arrays.asList(2,3,4,5);
	List<Integer> square = map.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);
	
//==========================================================================
	//Filter
	List<Integer> filter  = Arrays.asList(2,3,4,5);
	List<Integer> result = filter.stream().filter(x -> x%2==0).collect(Collectors.toList());
	 
	System.out.println(result);
	
//============================================================================
	
	//SORT
	
	List<Integer> sort  = Arrays.asList(4,6,5,3);
	List<Integer> sortResult = sort.stream().sorted().collect(Collectors.toList());
	 
	System.out.println(sortResult);
	
//===========================================================================
	
	//REDUCE
	
	List<Integer> reduce  = Arrays.asList(4,6,5,3);
	int redueResult = reduce.stream().reduce(0, (ans, i)-> ans+i);
	 
	System.out.println(redueResult);
	
	
//==============================================================================
	// DISTINCT
	
	List<Integer> distinct  = Arrays.asList(4,6,5,5,3,6);
	List<Integer> distinctResult = distinct.stream().distinct().collect(Collectors.toList());
	 
	System.out.println(distinctResult);
	
	
//==============================================================================
	//MAX
	
	List<Integer> max  = Arrays.asList(9,4,6,5,3,7,8);
//  Optional<Integer> maxResult = max.stream().max((n1,n2)-> Integer.compare(n1, n2));
	int maxResult = max.stream().max((n1,n2)-> Integer.compare(n1, n2)).get();

	System.out.println(maxResult);

	
	}
}
