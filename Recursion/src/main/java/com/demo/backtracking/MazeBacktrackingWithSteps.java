package com.demo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeBacktrackingWithSteps {

	public static void main(String[] args) {
       boolean[][] board = {
    		   {true, true, true},
    		   {true, true, true},
    		   {true, true, true}
       };
       
       int [][] path=new int[board.length][board[0].length];
       mazeRestrictions("", board, 0, 0, path, 1);
	}
	
	static void mazeRestrictions(String p, boolean[][] maze, int r, int c, int [][]path, int steps) {
		
		if(r == maze.length-1 && c == maze[0].length-1) {
			path[r][c]= steps;
			for(int[] arr: path) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(p);
			System.out.println();
			return ;
		}
		
		if(!maze[r][c]) {
			return;
		}
		
		maze[r][c]= false;
		path[r][c]= steps;
		if(r <  maze.length-1) {
		mazeRestrictions(p + "D", maze, r+1, c, path, steps+1);
		}
		
		if(c < maze[0].length-1) {
			mazeRestrictions(p + "R", maze, r, c+1, path, steps +1);
		}
		
		if(r > 0) {
			mazeRestrictions(p+ "U", maze, r-1, c, path, steps+1);
		}
		
		if(c > 0) {
			mazeRestrictions(p+ "L", maze, r, c-1, path, steps +1);
		}
		
		maze[r][c]= true;
		path[r][c]= 0;
	}
	
}
