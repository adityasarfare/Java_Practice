package org.example.DFS;

import org.example.BFS.TreeNode;

public class FindPath15 {
//In the book
	public boolean findPath(TreeNode node, int[] arr) {
		if(node == null) {
			return arr.length == 0;
		}
		return helper(node, arr, 0);
	}

	private boolean helper(TreeNode node, int[] arr, int index) {
		if(node == null) {
			return false;
		}
		
		if(index >= arr.length-1 || node.val != arr[index]) {
			return false;
		}
		
		if(node.left == null && node.right == null && index == arr.length-1) {
			return true;
		}
		
		return helper(node.left, arr, index+1) || helper(node.right, arr, index+1);
	}
}


//The line:
//
//java
//Copy code
//if (node == null) {
//    return arr.length == 0;
//}
//is used to handle the edge case where the tree is completely empty (node == null), and we need to check if the input array arr is also empty. Here's why it's necessary and how it works.
//
//Explanation:
//Base Case: An Empty Tree (node == null)
//
//If the tree is empty, there are no nodes to traverse. In this case:
//If the input array arr is empty (arr.length == 0), the path exists because there's nothing to match.
//If arr is not empty, then there’s no way to find a path in the tree that matches the array. Hence, the method should return false.
//This ensures that the method behaves correctly when dealing with an empty tree.
//
//Why Check arr.length == 0?
//
//If arr.length == 0, we're essentially asking if the tree matches an empty path.
//For an empty tree (node == null), an empty path is valid because there's nothing to match.
//For a non-empty tree, an empty path is invalid since the tree has nodes, and there’s no "path" to match against an empty array.
//Example Cases:

//Case 1: Empty Tree (node == null) and Empty Array (arr = [])
//java
//Copy code
//TreeNode node = null;
//int[] arr = {};
//Here, node == null is true, and arr.length == 0 is also true.
//Return true because an empty array matches an empty tree.


//Case 2: Empty Tree (node == null) and Non-Empty Array (arr = [1, 2, 3])
//java
//Copy code
//TreeNode node = null;
//int[] arr = {1, 2, 3};
//node == null is true, but arr.length == 0 is false.
//Return false because an empty tree cannot match a non-empty path.


//Case 3: Non-Empty Tree and Array
//For non-empty trees, this condition is skipped because node != null. The rest of the logic handles checking whether the path matches the array.
//
//Summary:
//The condition:
//
//java
//Copy code
//if (node == null) {
//    return arr.length == 0;
//}
//is a safeguard to handle the special case of an empty tree and ensures that the method works correctly for all scenarios:
//
//An empty tree with an empty array returns true.
//An empty tree with a non-empty array returns false.
//A non-empty tree skips this check and proceeds with the normal traversal logic.