package com.demo.String;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

	public static void main(String[] args) {
	int [] arr = {1,2,2};
	List<List<Integer>> ans = subSetDupliate(arr);
	
	for(List<Integer> r : ans) {
		System.out.println(r);
	}
		
	}
	
static List<List<Integer>> subSet(int[] arr){
		
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		outer.add(new ArrayList<Integer>());
		for(int num : arr) {
			int n = outer.size();
			for(int i=0; i<n; i++) {
				List<Integer> inner = new ArrayList<Integer>(outer.get(i));
				inner.add(num);
				outer.add(inner);
			}
		}
		
		return outer;
	}
	
static List<List<Integer>> subSetDupliate(int[] arr){
		
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		outer.add(new ArrayList<Integer>());
		
		int start=0;
		int end =0;
		
		for(int i=0; i < arr.length; i++) {
			start=0;
			
			if(i>0 && arr[i] == arr[i-1]) {
				start = end +1;
			}
			end = outer.size()-1;
			int n = outer.size();
			for(int j=start; j<n; j++) {
				List<Integer> inner = new ArrayList<Integer>(outer.get(j));
				inner.add(arr[i]);
				outer.add(inner);
			}
		}
		
		return outer;
	}
}
