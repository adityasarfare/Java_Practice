package com.demo.String;

import java.util.stream.Stream;

public class StringMethods {

	
	public static void main(String args[]) {
		
//============Validaing user Input===============//		
       String  s1 = "Aditya";

       String s2 = "Aditya";
		
//		System.out.println(s1.length());
//		
//		System.out.println(s1.isEmpty());
//		
//		System.out.println(s1.trim());
		

       
//============Comparing two String===============//	
       
       String s3 = "Aditya";
       String s4 = "AdITYa";
//        System.out.println(s3.equals(s4));
//       System.out.println(s3.equalsIgnoreCase(s4));
//       System.out.println(s3.compareTo(s4));
            
//============Concatenate Two String===============//	
       
       String s5 = "aditya is goodboy";
       String s6 = " great";
//     System.out.println(s5.concat(s6));
//     System.out.println(String.join(",", s5,s6));
//     System.out.println(s5.subSequence(3, 7));
//    System.out.println(s5.substring(5));
       
//============Replace Two String===============//
       String s7 = "aditya is goodboy";
       String s8 = "man";
//     System.out.println(s7);
//     System.out.println(s7.replace("d", "q"));
//     System.out.println(s7.replaceFirst("*", "x")); //it will provide exception
     
       
//============Searching Characters===============//
       String s9 = "aditya is goodboy";
       String s10 = "man";
//       System.out.println(s9.indexOf("i"));
//       System.out.println(s9.lastIndexOf("o"));
//       System.out.println(s9.charAt(5));
//       System.out.println(s9.contains(s10));  
//       System.out.println(s9.startsWith("adi"));
//       System.out.println(s9.endsWith("boy"));
       
//============Case Conversion===============//  
       
       String s11 ="aditya is engineer";
       System.out.println(s9.toUpperCase());
       System.out.println(s9.toLowerCase());
       
       int a =4;
       String s12 = String.valueOf(a);
       System.out.println(s12);
      
       
       

	}

}
