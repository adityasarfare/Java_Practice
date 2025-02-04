package com.demo.passByValueReference;

public class PassByReference {
	public static void modifyArray(int[] arr) {
        arr[0] = 20;  // Modify the first element of the array
        System.out.println("Inside modifyArray: " + arr[0]);  // Prints 20
    }

    public static void main(String[] args) {
        int[] number = {10};  // Create an array with one element, value is 10
        modifyArray(number);  // Pass the array to the method
        System.out.println("After modifyArray: " + number[0]);  // Prints 20
    }
    
    
}
//Java passes objects (arrays, for example) by reference: When you pass an object to a method, you pass the reference (or memory address) of that object. 
//This means that the method can modify the contents of the object because the method has access to the actual object, not just a copy.

//Explanation:
//We create an array number with a single element initialized to 10 (int[] number = {10};).
//We then pass the array to the modifyArray method.
//Since arrays are reference types in Java, when we pass the array to the method, the method has access to the actual array object (not a copy). This allows the method to modify the contents of the array.
//Inside the method, we modify the value at index 0 of the array (arr[0] = 20;), which affects the original array in the main method.
//After the method call, the value of number[0] is now 20 because the method directly modified the value of the array's element.
