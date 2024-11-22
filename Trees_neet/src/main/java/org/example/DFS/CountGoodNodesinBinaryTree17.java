package org.example.DFS;

import org.example.BFS.TreeNode;

public class CountGoodNodesinBinaryTree17 {

	public int goodNodes(TreeNode root) {
	
      return helper(root, root.val);
	}
	
	private int helper(TreeNode root, int maxSoFar) {
		if(root == null) {
			return 0;
		}
		
		int count = 0;
		if( root.val >= maxSoFar) {
			count = 1;
		}
		
		maxSoFar = Math.max(maxSoFar, root.val);
		
		count += helper(root.left, maxSoFar);
		count += helper(root.right, maxSoFar);
		
		return count;
	}
}
