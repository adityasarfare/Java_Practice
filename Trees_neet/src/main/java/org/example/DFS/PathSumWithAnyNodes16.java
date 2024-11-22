package org.example.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.example.BFS.TreeNode;

public class PathSumWithAnyNodes16 {

	int countPath(TreeNode node, int sum) {
	List<Integer> path = new LinkedList<>();
	return helper( node ,path, sum);
	
	}

	private int helper(TreeNode node, List<Integer> path, int sum) {
		if(node == null) {
			return 0;
		}
	
		path.add(node.val);
		int count =0;
		int s =0;
		
		ListIterator<Integer> itr = path.listIterator();
		while(itr.hasPrevious()) {
			s += itr.previous();
			if(sum == s) {
				count ++;
			}
		}
		
		count += helper(node.left, path, sum) + helper(node.right, path, sum);
		
		path.remove(path.size()-1);
		return count;
	}
	
	// put it in a list
	
	List<List<Integer>> countPaths(TreeNode node, int sum) {
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper1( node, sum, path, paths);
		return paths;
		}

		private void helper1(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths) {
			if(node == null) {
				return;
			}
		
			path.add(node.val);
			
			if(node.val == sum && node.left == null && node.right == null) {
				paths.add(new ArrayList<>(path));
			}
			else {
				helper1(node.left, sum - node.val, path, paths);
				helper1(node.right, sum - node.val, path, paths);
			}

			path.remove(path.size()-1);
		}
}
