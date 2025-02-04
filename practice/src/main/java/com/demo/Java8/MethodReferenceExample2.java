package com.demo.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using lambda expression
        List<Person> peopleLambda = mapToList(names, name -> new Person(name));

        // Using constructor method reference
        List<Person> peopleReference = mapToList(names, Person::new);

        // Print results
        peopleLambda.forEach(person -> System.out.println(person.getName()));
        System.out.println("---");
      
//        peopleReference.forEach(person -> System.out.println(person.getName()));
        peopleReference.stream().forEach(Person::getName);
    }

    public static <T, R> List<R> mapToList(List<T> list, Function<T, R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }
	}
	

