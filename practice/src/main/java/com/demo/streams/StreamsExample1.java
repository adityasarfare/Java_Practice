package com.demo.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample1 {

	public static void main(String[] args) {
		
		//Creating Immutable List, allows null (using toList())
		
		var immutableList = Stream.of("green", "blue", null).toList();
//		immutableList.add("yellow");
		System.out.println(immutableList);
		
		// Creating modifiable List, allows null (using collect(Collectors.toList()))
		var modifiableList = Stream.of("green", "blue", null).collect(Collectors.toList());
		modifiableList.add("yellow");
		modifiableList.set(2, "orange");
		System.out.println(modifiableList);
	
	
	//Grouping Products by category
	
	record Product(String name,
			       String category,
			       int price) {} 
	
	Stream<Product> products = Stream.of(
			new Product("Laptop", "Electronics", 1000),
			new Product("TV", "Electronics", 1500),
			new Product("Sofa", "Furniture", 700),
			new Product("Table", "Furniture", 500),
			new Product("Lamp", "HomedDecor", 400));
	
//	Map<String, List<Product>> groupProductsByCategory =
//			products.collect(Collectors.groupingBy(Product::category));
//	
//	System.out.println(groupProductsByCategory);
	
	//Aggregation: Calculating the total price
	//of product category
//	Map<String, Integer> aggregationProductsByCategory =
//			products.collect(Collectors.groupingBy(Product::category, 
//					Collectors.summingInt(Product::price)));
//	
//	System.out.println(aggregationProductsByCategory);
	
	//Average: Calculating the total price
		//of product category
//		Map<String, Double> averagPriceByCategory =
//				products.collect(Collectors.groupingBy(Product::category, 
//						Collectors.averagingDouble(Product::price)));
//		
//		System.out.println(averagPriceByCategory);

		//Count: Count the products in each category

//				Map<String, Long> countProductByCategory =
//						products.collect(Collectors.groupingBy(Product::category, 
//								Collectors.counting()));
//				
//				System.out.println(countProductByCategory);
				
//   Filtering: Products with price greater than 50;
//	    var filteredProducts = products.filter(product -> product.price>700).collect(Collectors.toList());
//	    System.out.println(filteredProducts);
		
//   Mapping: Extracting Product Names
//		var extractProductCategories = products.map(Product::category).collect(Collectors.toList());
//		System.out.println(extractProductCategories);
	
//   Partiotioning: Separate Products into expensive and cheap
//		var partionProducts = products.collect(Collectors.partitioningBy(product -> product.price > 700));
//		System.out.println(partionProducts);

	//Summarize :Summary Statistics for product prices
	// sum, avergae, max, min, count(5 metrices)
	Map<String, IntSummaryStatistics> summaryStatisticsByCategory =
			products.collect(Collectors.groupingBy(Product::category, 
					Collectors.summarizingInt(Product::price)));

        System.out.println(summaryStatisticsByCategory);
	}
}
