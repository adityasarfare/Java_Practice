package org.example.DFS;

import org.example.BFS.TreeNode;

//108
public class ConvertSortedArraytoBinarySearchTree4 {


      public TreeNode sortedArrayToBST(int[] nums) {
   
    	  return helper(nums, 0, nums.length-1);  
       }

	private TreeNode helper(int[] nums, int start, int end) {
		// TODO Auto-generated method stub

		if(start > end) {
		  return null;		
		}
		
		int m = (start + end)/2;
          
		TreeNode node = new TreeNode(nums[m]);
		
		node.left = helper(nums, start, m-1);
		node.right = helper(nums, m+1, end);
		
		return node;	
	}
}