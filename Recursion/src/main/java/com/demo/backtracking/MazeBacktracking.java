package com.demo.backtracking;

import java.util.ArrayList;

public class MazeBacktracking {

	public static void main(String[] args) {
       boolean[][] board = {
    		   {true, true, true},
    		   {true, true, true},
    		   {true, true, true}
       };
       
       mazeRestrictions("", board, 0, 0);
	}
	
	static void mazeRestrictions(String p, boolean[][] maze, int r, int c) {
		
		if(r == maze.length-1 && c == maze[0].length-1) {
			System.out.println(p);
			return ;
		}
		
		if(!maze[r][c]) {
			return;
		}
		
		maze[r][c]= false;
		
		if(r <  maze.length-1) {
		mazeRestrictions(p + "D", maze, r+1, c);
		}
		
		if(c < maze[0].length-1) {
			mazeRestrictions(p + "R", maze, r, c+1);
		}
		
		if(r > 0) {
			mazeRestrictions(p+ "U", maze, r-1, c);
		}
		
		if(c > 0) {
			mazeRestrictions(p+ "L", maze, r, c-1);
		}
		
		maze[r][c]= true;
	}
	
}
