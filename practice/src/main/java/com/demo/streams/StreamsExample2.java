package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Transaction {
	
	private String catgegory;
	
	private int amount;

	public Transaction(String catgegory, int amount) {
		super();
		this.catgegory = catgegory;
		this.amount = amount;
	}

	public String getCatgegory() {
		return catgegory;
	}

	public void setCatgegory(String catgegory) {
		this.catgegory = catgegory;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
public class StreamsExample2 {

	public static void main(String[] args) {
		
		List<Transaction> list = Arrays.asList(
				new Transaction("Grocery", 2500),
				new Transaction("Entertainment", 500),
				new Transaction("Utilities", 1000),
				new Transaction("Grocery", 1500),
				new Transaction("Entertainment", 1000),
				new Transaction("Utilities", 2000)
				);
		
		//Use case1 : Calculate total amount spend on category grocery
		int resultSum = list.stream()
				               .filter(x -> x.getCatgegory().equals("Grocery"))
				               .mapToInt(Transaction::getAmount)
				               .sum();
		System.out.println(resultSum);
		
		//Use case2 : Calculate average  amount spend on categories
		double resultAverage = list.stream()
				                   .mapToDouble(x->x.getAmount())
				                   .average().orElse(0);
		System.out.println(String.format("%.2f", resultAverage));
	}
}
