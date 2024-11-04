package com.demo.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindElements {

	public static void main(String[] args) {
		
		int[] arr = {1,2,4,4,18,9,5};
//		System.out.println(find(arr, 18, 0));
//		System.out.println(findIndex(arr, 18, 0));
//		System.out.println(findIndexBack(arr, 18, arr.length-1));
//		 findIndexInArray(arr, 4, 0);
//		System.out.println(list);
//		
//		ArrayList<Integer> list = findIndexInArrayParamter(arr, 4, 0, new ArrayList<Integer>());
//		System.out.println(list);
		
		ArrayList<Integer> a = findIndexArrayInBody(arr, 4, 0);
		System.out.println(a);
		
		
	}
	
	static boolean find(int[] arr, int target, int index) {
		
	
		if(index == arr.length) {
			return false;
		}
		
		return arr[index] == target || find(arr, target, index+1);
	}
	
	static int findIndex(int[] arr, int target, int index) {
		if(index == arr.length) {
			return -1;
		}
		
		if (arr[index] == target ) {
			return index;
		}
	
		return  findIndex(arr, target, index+1);
		
	}
	
	static int findIndexBack(int[] arr, int target, int index) {
		if(index == -1) {
			return -1;
		}
		
		if (arr[index] == target ) {
			return index;
		}
	
		return  findIndexBack(arr, target, index-1);
		
	}
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static void findIndexInArray(int[] arr, int target, int index) {
		if(index == arr.length) {
			return;
		}
		
		if (arr[index] == target ) {
			list.add(index);
		}
	
		findIndexInArray(arr, target, index+1);
		
	}
	
	
	static ArrayList<Integer> findIndexInArrayParamter(int[] arr, int target, int index, ArrayList<Integer> list) {
		if(index == arr.length) {
			return list;
		}
		
		if (arr[index] == target ) {
			list.add(index);
		}
	
		return  findIndexInArrayParamter(arr, target, index+1, list);
		
	}
	
	static ArrayList<Integer> findIndexArrayInBody(int[] arr, int target, int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(index == arr.length) {
			return list;
		}
//		int[] arr = {1,2,4,4,18,9,5};
		if (arr[index] == target ) {
			list.add(index);
		}
	
		ArrayList<Integer> ans =  findIndexArrayInBody(arr, target, index+1);
		
		list.addAll(ans);
		
		return list;
		
	}
}
