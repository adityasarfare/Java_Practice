package org.example.DFS;

import org.example.BFS.TreeNode;
//110
public class BalancedBinaryTree17 {

	 public boolean isBalanced(TreeNode root) {
	        
		return helper(root) != -1;
	    }
	 
	 private int helper(TreeNode node) {
	 if(node == null) {
		 return 0;
	 }
	 
	 int left = helper(node.left);
	 if(left == -1) {
	 return -1;
	 }
	 
	 int right = helper (node.right);
	 if(right == -1) {
		 return -1;
	 }
	 
	 if(Math.abs(left - right ) >1) {
		 return -1;
	 }
	 

	return Math.max(left, right) +1;
	
	 }
	 
	 
}



//Let’s evaluate the input root = [1,2,3,null,null,4,null,5], which represents the following binary tree:
//
//markdown
//Copy code
//        1
//       / \
//      2   3
//         /
//        4
//       /
//      5
//We'll walk through the execution of the isBalanced function step-by-step.
//
//Steps of Execution
//1. Call isBalanced(root)
//
//This calls helper(root) with root as 1.
//2. Compute helper(1)
//
//Calls helper(2) for the left subtree of 1.
//Calls helper(3) for the right subtree of 1.
//Compute helper(2):
//Node 2 is a leaf node (both left and right children are null).
//helper(null) is called twice (for 2's left and right children), both return 0.
//Height of 2 = Math.max(0, 0) + 1 = 1.
//Returns 1.
//Compute helper(3):
//Calls helper(4) for the left subtree of 3.
//Calls helper(null) for the right subtree of 3.
//Compute helper(4):
//Calls helper(5) for the left subtree of 4.
//Calls helper(null) for the right subtree of 4.
//Compute helper(5):
//Node 5 is a leaf node (both left and right children are null).
//helper(null) is called twice (for 5's left and right children), both return 0.
//Height of 5 = Math.max(0, 0) + 1 = 1.
//Returns 1.
//Back to helper(4):
//Left height of 4 = 1 (from helper(5)).
//Right height of 4 = 0 (from helper(null)).
//Height of 4 = Math.max(1, 0) + 1 = 2.
//The difference between the left and right heights is |1 - 0| = 1 (balanced at 4).
//Returns 2.
//Back to helper(3):
//Left height of 3 = 2 (from helper(4)).
//Right height of 3 = 0 (from helper(null)).
//Height of 3 = Math.max(2, 0) + 1 = 3.
//The difference between the left and right heights is |2 - 0| = 2 (unbalanced at 3).
//Unbalanced detected: helper(3) immediately returns -1.
//Back to helper(1):
//Left height of 1 = 1 (from helper(2)).
//Right height of 1 = -1 (from helper(3)).
//Since one of the subtrees returned -1, helper(1) immediately returns -1.
//Final Result
//Since helper(1) returned -1, the isBalanced(root) function returns false.
//Key Points of Execution
//The recursive function calculates the height of each subtree while simultaneously checking for balance.
//Node 5 is balanced, with a height of 1.
//Node 4 is balanced, with a height of 2.
//Node 3 is unbalanced because its left subtree height is 2 and its right subtree height is 0 (difference |2 - 0| = 2).
//The unbalanced subtree at 3 propagates the imbalance back to the root, making the entire tree unbalanced.
//
//
//
//
//
