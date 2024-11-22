package org.example.DFS;

import org.example.BFS.TreeNode;

public class KthSmallestElementinaBST8 {
	int count =0;
  public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }
// Tip whenever it is asking for for smaller elements use In-order
  // In Binary serach tree if it is asking sortes order use inorder traversa
  private TreeNode helper(TreeNode node, int k) {
	
	if(node == null) {
		return null;
	}
	
	TreeNode left = helper(node.left, k);
	
	if(left != null) {
		return left;
	}
	
	count ++;
	
	if(count == k) {
		return node;
	}
	
	return helper(node.right, k);
}
}


//Let's step through the execution of the code for the input:

//Tree structure:
//markdown
//Copy code
//      3
//     / \
//    1   4
//     \
//      2
//k = 1: We need to find the smallest (1st smallest) element.
//Execution of kthSmallest(root, 1):
//The main method calls helper(root, 1) where root is the node with value 3.
//Recursive Steps
//Step 1: Start at Node 3
//Current node.val = 3.
//Perform helper(node.left, 1) (go to the left subtree).

//Step 2: Move to Node 1
//Current node.val = 1.
//Perform helper(node.left, 1) (go to the left subtree).

//Step 3: Left of Node 1 is NULL
//node == null, so return null.

//Step 4: Back to Node 1
//No node was found in the left subtree, so:
//Increment count → count = 1.
//Check if (count == k):
//count == 1, so k == 1.
//Return node (Node 1).

//Step 5: Back to Node 3
//The left subtree of Node 3 returned Node 1 (the k-th smallest node).
//Since left != null, return left (Node 1).
//Final Result
//The k-th smallest node is Node 1, with a value of 1.

//Detailed Breakdown of count
//The code uses count to track the nodes visited in sorted order:
//Node 1: Increment count to 1 (matches k).
//No further traversal is needed after finding the k-th node.
//Why Does This Work?
//The code uses inorder traversal, which processes nodes in sorted order for BSTs.
//The if (count == k) condition ensures we stop traversal as soon as the desired element is found.
//The recursive structure ensures we return the k-th node back through the call stack.