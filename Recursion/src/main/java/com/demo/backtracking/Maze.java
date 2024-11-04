package com.demo.backtracking;

import java.util.ArrayList;

public class Maze {

	public static void main(String[] args) {
//	System.out.println(	noofPaths(3, 3));
//		actualPaths("", 3, 3);
		
		System.out.println(actualPathsReturn("", 3, 3));
		
//		System.out.println(actualPathsDiagonal("", 3, 3));
	}
	
     static int noofPaths(int r, int c) {
		
		if(r==1 || c==1) {
			return 1;
		}
		
		int left= noofPaths(r-1, c);
		int right= noofPaths(r, c-1);
		
		return left + right;
	}
	
     static void actualPaths(String p, int r, int c) {
		
		if(r==1 && c==1) {
			System.out.println(p);
			return ;
		}
		
		if(r>1) {
			actualPaths(p+"D", r-1, c);
		}
		
		if(c>1) {
			actualPaths(p+"R", r, c-1);
		}
		
		
	}


static ArrayList<String> actualPathsReturn(String p, int r, int c) {
	
	if(r==1 && c==1) {

        ArrayList<String> list = new ArrayList<>();
          list.add(p);
			return list ;
	}
	
	ArrayList<String> list = new ArrayList<>();
    
	if(r>1) {
	list.addAll(actualPathsReturn(p+"D", r-1, c));
	}
	
	if(c>1) {
		list.addAll(actualPathsReturn(p+"R", r, c-1));
	}
	
	return list;
	
}

static ArrayList<String> actualPathsDiagonal(String p, int r, int c) {
	
	if(r==1 && c==1) {

        ArrayList<String> list = new ArrayList<>();
          list.add(p);
			return list ;
	}
	
	ArrayList<String> list = new ArrayList<>();
    
	if(r>1 && c >1) {
		list.addAll(actualPathsDiagonal(p+"D", r-1, c-1));
		}
	
	if(r>1) {
	list.addAll(actualPathsDiagonal(p+"V", r-1, c));
	}
	
	if(c>1) {
		list.addAll(actualPathsDiagonal(p+"H", r, c-1));
	}
	
	return list;
	
}
}
