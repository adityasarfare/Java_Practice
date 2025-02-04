package com.demo.FileIO;

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

public class FileOp  {



	public static void main(String[] args) {

   try {
	FileReader fileWriter = new FileReader("src/main/resources/adi.txt");
	BufferedReader bufferedreader = new BufferedReader(fileWriter);

       
       System.out.println(bufferedreader.readLine());
       bufferedreader.close();

} catch (IOException e) {
	
	e.printStackTrace();
}
   
}
}