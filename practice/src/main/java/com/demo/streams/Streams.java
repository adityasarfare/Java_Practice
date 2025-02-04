package com.demo.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams  {



	public static void main(String[] args) {


       int ab[] = {1,3,4,5,6};
		
//		ArrayList<String> a = new ArrayList<>();
//		a.add("Adi");
//		a.add("mani");
//		a.add("raj");
//		
//		a.stream().forEach(System.out::println);
       
       
       ArrayList<Integer> a = new ArrayList<>();
       a.add(4);
       a.add(5);
       a.add(6);
       
       
       
//     int as =  a.stream().reduce(0,(ans, i) -> ans + i);
//     System.out.println(as);
	
	
//	
//	int[] a = {123, 456, 789};

    // Use IntStream to iterate over the array, and then iterate over each digit
//    Arrays.stream(a)
//            .flatMap(x -> String.valueOf(x).chars())  // Convert each integer to its digits
//            .forEach(c -> System.out.println(Character.getNumericValue(c)));

}
}