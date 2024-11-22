package org.example.DFS;

import java.util.Arrays;

import org.example.BFS.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal9 {

 public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
        	return null;
        }
        
        int r = preorder[0];
        int index =0;
        
        for(int i=0; i< inorder.length; i++) {
        	if(r == inorder[i]) {
        		index = i;
        	}
        }
        TreeNode node = new TreeNode(r);
        
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));

        
        return node;
    }
}
