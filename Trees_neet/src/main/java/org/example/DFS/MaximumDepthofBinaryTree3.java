package org.example.DFS;

import org.example.BFS.TreeNode;

//104
public class MaximumDepthofBinaryTree3 {

	 public int maxDepth(TreeNode root) {
	        
		 if(root == null) {
			 return 0;
		 }
		 
		 int leftNode = maxDepth(root.left);
		 int rightNode = maxDepth(root.right);
		 
		 return Math.max(leftNode, rightNode) +1;
	    }
}
