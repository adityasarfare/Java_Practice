package com.demo.wap;

import java.util.Scanner;

public class Calculator {

	
	public static void main(String[] args) {
		String yn;
		do {
			
		
		Scanner s = new Scanner(System.in);
		System.out.println("No1:");
		int no1 = s.nextInt();
		System.out.println("No2:");
		int no2 = s.nextInt();
        System.out.println("Pass the operator");
        String sym = s.next();
        
        int res;
        
        switch (sym) {
		case "+": res = no1+no2;
		          System.out.println("Addition "+ res);
		          break;
		case "-": res = no1-no2;
        System.out.println("Subtraction "+ res);
                  break;
		case "/": res = no1/no2;
        System.out.println("Division "+ res);
                  break;
		case "*": res = no1*no2;
        System.out.println(" "+ res);
                  break;
        
			
		
		default:
			System.out.println("The operator cannot be used");
		}
        
        System.out.println("To continuw press Yes or no");
        
        yn = s.next();
		} while (yn.equalsIgnoreCase(yn));
	}
		
}
