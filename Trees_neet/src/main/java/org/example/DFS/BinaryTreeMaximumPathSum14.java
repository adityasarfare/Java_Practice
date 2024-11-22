package org.example.DFS;

import org.example.BFS.TreeNode;
//124 (*)
public class BinaryTreeMaximumPathSum14 {
	int ans = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
	
	private int helper(TreeNode node) {
	
		if(node == null) {
			return 0;
		}
		
		int left = helper(node.left);
		int right = helper(node.right);
		
		left = Math.max(0, left);
		right = Math.max(0, right);
		
		int pathSum = left + right + node.val;
		
		ans = Math.max(ans, pathSum);
		
		return Math.max(left, right) + node.val;
	}
}

//return Math.max(left, right) + node.val;
// This line of code is requires to find the largest path which will be passed to above node
// for example :- for -10, the paths could be 20->15 or 20->7 so we want the largest path

//Tree Structure
//markdown
//Copy code
//        -10
//        /  \
//       9    20
//           /  \
//         15    7
//Step-by-Step Iterations (Starting at Node 9)
//1. Process Node 9
//node = 9, no left or right children.
//Left sum: helper(node.left) = 0 (no left child).
//Right sum: helper(node.right) = 0 (no right child).
//Values after processing:
//left = Math.max(0, 0) = 0.
//right = Math.max(0, 0) = 0.
//pathSum = left + right + node.val = 0 + 0 + 9 = 9.
//Update global ans: ans = Math.max(Integer.MIN_VALUE, 9) = 9.
//Return to parent: Math.max(left, right) + node.val = Math.max(0, 0) + 9 = 9.


//2. Process Node 15
//node = 15, no left or right children.
//Left sum: helper(node.left) = 0.
//Right sum: helper(node.right) = 0.
//Values after processing:
//left = Math.max(0, 0) = 0.
//right = Math.max(0, 0) = 0.
//pathSum = left + right + node.val = 0 + 0 + 15 = 15.
//Update global ans: ans = Math.max(9, 15) = 15.
//Return to parent: Math.max(left, right) + node.val = Math.max(0, 0) + 15 = 15.


//3. Process Node 7
//node = 7, no left or right children.
//Left sum: helper(node.left) = 0.
//Right sum: helper(node.right) = 0.
//Values after processing:
//left = Math.max(0, 0) = 0.
//right = Math.max(0, 0) = 0.
//pathSum = left + right + node.val = 0 + 0 + 7 = 7.
//Update global ans: ans = Math.max(15, 7) = 15.
//Return to parent: Math.max(left, right) + node.val = Math.max(0, 0) + 7 = 7.


//4. Process Node 20
//node = 20, left child is 15 and right child is 7.
//Left sum: helper(node.left) = 15 (from previous step).
//Right sum: helper(node.right) = 7 (from previous step).
//Values after processing:
//left = Math.max(0, 15) = 15.
//right = Math.max(0, 7) = 7.
//pathSum = left + right + node.val = 15 + 7 + 20 = 42.
//Update global ans: ans = Math.max(15, 42) = 42.
//Return to parent: Math.max(left, right) + node.val = Math.max(15, 7) + 20 = 35.


//5. Process Root Node -10
//node = -10, left child is 9 and right child is 20.
//Left sum: helper(node.left) = 9 (from Node 9).
//Right sum: helper(node.right) = 35 (from Node 20).
//Values after processing:
//left = Math.max(0, 9) = 9.
//right = Math.max(0, 35) = 35.
//pathSum = left + right + node.val = 9 + 35 + (-10) = 34.
//Update global ans: ans = Math.max(42, 34) = 42.
//Return to parent: Math.max(left, right) + node.val = Math.max(9, 35) + (-10) = 25.


//Final Answer
//The global variable ans contains the maximum path sum, which is 42.