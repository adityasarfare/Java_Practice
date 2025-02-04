package com.demo.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartForStreampAPI {

	
	
	   public static List<Customer> getall(){
		   
		  return Stream.of(
				  new Customer(1, "Aditya", "mum", Arrays.asList("12346", "12345")),
				  new Customer(2, "Raghu", "mum", Arrays.asList("9768384405", "7066703478")),
				  new Customer(3, "manoj", "mum", Arrays.asList("8652335966", "9702626925"))
				  ).collect(Collectors.toList());
				  
	   }
	   
	   
	
}
