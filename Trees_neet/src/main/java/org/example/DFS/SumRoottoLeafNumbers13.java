package org.example.DFS;

import org.example.BFS.TreeNode;
//129
public class SumRoottoLeafNumbers13 {
  public int sumNumbers(TreeNode root) {
        
	  int n = helper (root , 0);
	  return n;
    }

  private int helper(TreeNode node, int i) {
	
	  if(node == null) {
		  return 0;
	  }
	  
	  int ans = (10 * i) + node.val;
	  
	  if(node.left == null && node.right== null) {
		  return ans;
	  }
	  int left = helper(node.left, ans);
	  
	  int right = helper(node.right, ans);
	  
	return left + right;
   }
}
