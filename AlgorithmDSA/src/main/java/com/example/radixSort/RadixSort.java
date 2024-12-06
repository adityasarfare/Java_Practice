package com.example.radixSort;

import java.util.Arrays;

public class RadixSort {

	public static void radixSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		
		for(int exp =1; max/exp >0; exp*=10) {
			countSort(arr, exp);
		}
	}
	private static void countSort(int[] arr, int exp) {
		int n= arr.length;
		int[] output = new int[n];
		int[] count = new int[10];
		
		Arrays.fill(count, 0);
		
		
		for(int i=0; i<n; i++){
			count[(arr[i]/exp)%10]++;
		}
		
		System.out.println("\nCount array for " + exp + " : " + Arrays.toString(count));
		

	    for(int i=1; i<10; i++) {
	      count[i] = count[i] + count[i-1];
	    }
	    
	    System.out.println("Updated count array " + Arrays.toString(count));
	    
	    for(int i=n-1; i>=0; i--) {
	        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	        count[(arr[i] / exp) % 10]--;
	      }
	    
	    System.out.println("Output array " + Arrays.toString(output));
	    
	    System.arraycopy(output, 0, arr, 0, n);
		
	}
	public static void main(String[] args) {
		 int[] arr = {29, 83, 471, 36, 91, 8};

		    System.out.println("Origin array: " + Arrays.toString(arr));
		    radixSort(arr);
		    System.out.println("Sorted array: " + Arrays.toString(arr));
	}
}


//he RadixSort class implements the Radix Sort algorithm, which is a non-comparative sorting algorithm that sorts integers by processing each digit of the numbers, starting from the least significant digit (LSD) to the most significant digit (MSD). Here's a step-by-step explanation of the code:
//
//Key Components
//1. radixSort(int[] arr)
//This is the main method responsible for initiating the radix sort.
//
//Find the maximum number:
//int max = Arrays.stream(arr).max().getAsInt();
//This determines the largest number in the array to know how many digits we need to process.
//
//Iterate over each digit's place:
//for (int exp = 1; max / exp > 0; exp *= 10)
//
//exp represents the digit place (1 = ones, 10 = tens, 100 = hundreds, etc.).
//The loop runs until max / exp > 0, ensuring that we process all digits of the largest number.
//Call countSort for each digit's place:
//For each digit position (exp), the countSort method is called to sort the array based on the current digit.
//
//2. countSort(int[] arr, int exp)
//This is the helper method that performs a stable counting sort on the current digit represented by exp.
//
//Initialize arrays:
//int[] output is used to store the sorted output for the current digit.
//int[] count is a frequency array of size 10 (0-9 for the digits).
//
//Count the occurrences of each digit:
//
//java
//Copy code
//for (int i = 0; i < n; i++) {
//    count[(arr[i] / exp) % 10]++;
//}
//This calculates the frequency of the digits at the current exp position.
//
//Example: For arr = {29, 83, 471, 36, 91, 8} and exp = 1 (ones place), the digits extracted are:
//
//29 % 10 = 9, 83 % 10 = 3, 471 % 10 = 1, 36 % 10 = 6, 91 % 10 = 1, 8 % 10 = 8.
//So, count = [0, 2, 0, 1, 0, 0, 1, 0, 1, 1].
//Calculate cumulative frequency:
//
//java
//Copy code
//for (int i = 1; i < 10; i++) {
//    count[i] = count[i] + count[i - 1];
//}
//Transform the count array into cumulative frequencies to determine the position of digits in the output array.
//
//Example:
//If count = [0, 2, 0, 1, 0, 0, 1, 0, 1, 1],
//after this step, count = [0, 2, 2, 3, 3, 3, 4, 4, 5, 6].
//
//Build the output array:
//
//java
//Copy code
//for (int i = n - 1; i >= 0; i--) {
//    output[count[(arr[i] / exp) % 10] - 1] = arr[i];
//    count[(arr[i] / exp) % 10]--;
//}
//Iterate from the end of the array to maintain stability.
//Use the cumulative frequency (count) to determine the position of each number in the output array.
//Example:
//For exp = 1, the output array becomes [471, 91, 83, 36, 8, 29].
//
//Copy the output back to the original array:
//
//java
//Copy code
//System.arraycopy(output, 0, arr, 0, n);
//After sorting based on the current digit, copy output back to arr for the next iteration.
//
//Execution Flow
//Input Array: {29, 83, 471, 36, 91, 8}
//The largest number is 471, so the algorithm will process three digit places: 1 (ones), 10 (tens), and 100 (hundreds).
//
//Digit Place: Ones (exp = 1)
//
//Count digits: [0, 2, 0, 1, 0, 0, 1, 0, 1, 1].
//Cumulative count: [0, 2, 2, 3, 3, 3, 4, 4, 5, 6].
//Output: [471, 91, 83, 36, 8, 29].
//Update arr to [471, 91, 83, 36, 8, 29].
//Digit Place: Tens (exp = 10)
//
//Count digits: [0, 1, 0, 2, 1, 0, 1, 0, 1, 0].
//Cumulative count: [0, 1, 1, 3, 4, 4, 5, 5, 6, 6].
//Output: [8, 29, 36, 471, 83, 91].
//Update arr to [8, 29, 36, 471, 83, 91].
//Digit Place: Hundreds (exp = 100)
//
//Count digits: [3, 2, 0, 0, 1, 0, 0, 0, 0, 0].
//Cumulative count: [3, 5, 5, 5, 6, 6, 6, 6, 6, 6].
//Output: [8, 29, 36, 83, 91, 471].
//Update arr to [8, 29, 36, 83, 91, 471].
//Final Sorted Array: [8, 29, 36, 83, 91, 471].