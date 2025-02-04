package com.demo.passByValueReference;

public class PassByValue {
	public static void modifyPrimitive(int n) {
        n = 20;  // Trying to modify the primitive value
        System.out.println("Inside modifyPrimitive: " + n);  // Prints 20
    }

    public static void main(String[] args) {
        int number = 10;
        modifyPrimitive(number);  // Passes the value of `number` (a copy of it)
        System.out.println("After modifyPrimitive: " + number);  // Prints 10
    }
}
//Primitive types in Java are passed by value: When you pass a primitive type (like int, char, boolean) to a method, the value of the variable is copied 
//and passed into the method. This means that the method works with a copy of the value, and any changes to this copy do not affect the original value outside the method.

//Explanation:
//The value of number is 10.
//When we call modifyPrimitive(number), the value of number (which is 10) is copied into the method parameter n.
//Inside the method, we change n to 20, but this change does not affect the original number in the main method.
//After the method call, the value of number remains 10 because the method worked with a copy of the value (not the original variable).