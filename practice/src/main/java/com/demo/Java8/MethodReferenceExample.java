package com.demo.Java8;

import java.util.Arrays;

public class MethodReferenceExample {

	public static void main(String[] args) {
        // Example 1: Static Method Reference
        String[] namesArray = {"Alice", "Bob", "Charlie", "David", "Emily"};
       
        

        // Using lambda expression
        Arrays.sort(namesArray, (s1, s2) -> StringHelper.compareByLength(s1, s2));

        // Using static method reference
        Arrays.sort(namesArray, StringHelper::compareByLength);

        System.out.println(Arrays.toString(namesArray));

        // Example 2: Instance Method Reference
        StringConcatenator stringConcatenator = new StringConcatenator();

        // Using lambda expression
        String concatenated1 = stringConcatenator.concatenate("Hello", " World", "!");
        System.out.println(concatenated1);

        // Using instance method reference
//        StringConcatenator stringConcatenatorRef = StringConcatenator::concatenate;
//        String concatenated2 = stringConcatenatorRef.concatenate("Good", "bye", "!");
//        System.out.println(concatenated2);
    }
}

class StringHelper {
    // Static method for comparing strings by length
    static int compareByLength(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}

class StringConcatenator {
    // Instance method for concatenating strings
     String concatenate(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }

}
