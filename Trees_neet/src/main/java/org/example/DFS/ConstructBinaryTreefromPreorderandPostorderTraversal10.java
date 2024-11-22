package org.example.DFS;

import org.example.BFS.TreeNode;

public class ConstructBinaryTreefromPreorderandPostorderTraversal10 {
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
	    if (preorder == null || preorder.length == 0 || postorder == null || postorder.length == 0) {
	        return null;
	    }

	    // Helper method to build the tree
	    return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
	    if (preStart > preEnd || postStart > postEnd) {
	        return null;
	    }

	    // The first node in preorder is always the root
	    TreeNode root = new TreeNode(preorder[preStart]);

	    // If there's only one element, it's a leaf node
	    if (preStart == preEnd) {
	        return root;
	    }

	    // The second node in preorder is the left child of the root
	    int leftRootVal = preorder[preStart + 1];

	    // Find the left subtree's root in postorder to determine the boundaries
	    int leftRootIndexInPost = postStart;
	    while (postorder[leftRootIndexInPost] != leftRootVal) {
	        leftRootIndexInPost++;
	    }

	    // Number of nodes in the left subtree
	    int leftSubtreeSize = leftRootIndexInPost - postStart + 1;

	    // Recursively construct the left and right subtrees
	    root.left = construct(preorder, preStart + 1, preStart + leftSubtreeSize, postorder, postStart, leftRootIndexInPost);
	    root.right = construct(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, leftRootIndexInPost + 1, postEnd - 1);

	    return root;
	}
}
