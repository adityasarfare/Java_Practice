package com.example.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku8 {

	public boolean isValidSudoku(char[][] board) {
	
	Set<String> seen = new HashSet<>();
	
	for(int i=0; i<9; i++) {
		for(int j=0; j<9; j++) {
			char c= board[i][j];
			
			if(c!='.') {
				if(!seen.add(c + "in rows" + i) ||
						!seen.add(c + "in col" + j) ||	
						      !seen.add(c + "in rows" + i/3 +1/3)) {
					return false;
				}
			}
		}
	}
	
	return true;
	}
}
