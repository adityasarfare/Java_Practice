package com.example.DFS;

public class SurroundedRegions6 {

	public void solve(char[][] board) {
		int ROWS = board.length;
		int COLS = board[0].length;
		
		for(int r=0; r<ROWS; r++) {
			if(board[r][0] == 'O') {
				capture(board, r ,0);
			}
			if(board[r][COLS-1] =='O') {
				capture(board, r, COLS-1);
			}
		}
		
		for(int c =0; c<COLS; c++) {
			if(board[0][c] == 'O') {
				capture(board, 0, c);
			}
			if(board[ROWS-1][c] =='O') {
				capture(board, ROWS-1, c);
			}
		}
		
		for(int i=0; i< ROWS; i++) {
			for(int j=0; j<COLS; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				else if(board[i][j] =='T') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void capture(char[][] board, int r, int c) {
		
		if(r <0 || r>=board.length || c<0 || c>=board[0].length ||
			board[r][c] != 'O') {
			return;
		}
		
		board[r][c]= 'T';
		capture(board, r+1, c);
		capture(board, r-1, c);
		capture(board, r, c+1);
		capture(board, r, c-1);
		
	}
}
