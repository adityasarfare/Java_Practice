package com.demo.Miscellanious;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerExample {

	public static void main(String args[]) {
// ==========Sacnner Example ==============
//		Scanner sc = new Scanner(System.in);
//		System.out.println();
//		String l =  sc.nextLine();
//		System.out.println(l);
		
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bufferedreader = new BufferedReader(isr);
            System.out.print("Enter your name: ");
		       
		       System.out.println(bufferedreader.readLine());
		       bufferedreader.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
