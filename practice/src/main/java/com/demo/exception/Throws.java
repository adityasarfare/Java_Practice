package com.demo.exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Throws {

	
	public static void main(String args[]) {
		
	
		
		
		try {
			Throws.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception");
		}
		
	}
	
	
	
	
	public static void show() throws Exception {
		
		
			FileWriter fileWriter = new FileWriter("src/main/resources/adi.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		        bufferedWriter.write("manual");
		        bufferedWriter.close();
		
//		int a = 6;
//		int b = 0;
//		
//		int c = a/b;

	}
	}

