package com.example.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

	int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int island = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					island++;
				}
			}
		}
		return island;
	}

	private void bfs(char[][] grid, int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		grid[r][c] = '0';
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int cell[] = q.poll();
			int cellrow = cell[0];
			int cellcol = cell[1];

			for (int[] dir : directions) {
				int row = cellrow + dir[0];
				int col = cellcol + dir[1];

				if (row >= 0 && row < grid.length && 
					col >= 0 && col < grid[0].length && 
					grid[row][col] == '1') {
					q.offer(new int[] { row, col });
					grid[row][col] = '0';

				}
			}
		}
	}
}
