package com.demo;

public class MazeSolver {

	public static void main(String[] args) {
        String originalString = "Hello, World!";
        String reversedString = reverseString(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }

    public static String reverseString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();
        System.out.println(charArray.length);

        // Use a for loop to reverse the character array
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            // Swap characters at position i and j
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        // Convert the character array back to a string and return
        return new String(charArray);
    }    


	
}
