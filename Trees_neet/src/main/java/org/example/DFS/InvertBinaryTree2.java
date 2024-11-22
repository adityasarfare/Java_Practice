package org.example.DFS;

import org.example.BFS.TreeNode;

public  class InvertBinaryTree2 {
// 226
  public TreeNode invertTree(TreeNode root) {
        
	  if(root == null) {
		  return null;
	  }
	  
	  TreeNode left = invertTree(root.left);
	  TreeNode right = invertTree(root.right);
	  
	  root.left = right;
	  root.right = left;
	  
	  return root;
    }
}
