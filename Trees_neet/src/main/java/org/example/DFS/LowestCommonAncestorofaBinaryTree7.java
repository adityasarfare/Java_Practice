package org.example.DFS;

import org.example.BFS.TreeNode;
//236
public class LowestCommonAncestorofaBinaryTree7 {
	   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
		   if(root == null) {
			   return null;
		   }
		   
		   if(root == p || root == q) {
			   return root;
		   }
		   
		   TreeNode left = lowestCommonAncestor(root.left, p, q);
		   TreeNode right = lowestCommonAncestor(root.right, p, q);

		   if(right != null && left != null) {
			   return root;
		   }
		   
		   return left==null ? right : left;
	    }
}
