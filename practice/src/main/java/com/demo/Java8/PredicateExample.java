package com.demo.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	
	public static void main(String args[]) {
		
		
       	Predicate<String> checklenght = s -> s.length() >= 5;
		
		System.out.println("length " + checklenght.test("codedecode"));
	
	
		Predicate<String> checkEvenlenght = s -> s.length() %2 == 0;

		System.out.println("length " + checkEvenlenght.test("codedecode"));
		
		
		System.out.println("using and " + checkEvenlenght.and(checkEvenlenght).test("codedecode"));
		System.out.println("using or " + checkEvenlenght.or(checkEvenlenght).test("codedecode"));
		System.out.println(checkEvenlenght.negate().test("codedecode"));
//======================================================================
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Predicate to check if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0;

        // Predicate to check if a number is greater than 5
        Predicate<Integer> isGreaterThan5 = number -> number > 5;

        // Filtering numbers based on predicates
        System.out.println("Even numbers:");
        filterAndPrint(numbers, isEven);

        System.out.println("\nNumbers greater than 5:");
        filterAndPrint(numbers, isGreaterThan5);
    }

    // Method to filter and print elements based on a predicate
    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
	}


