package org.example.DFS;

import org.example.BFS.TreeNode;
// 114 (*)
public class FlattenBinaryTreetoLinkedList5 {
  
	public void flatten(TreeNode root) {
     //1.Normal pre order traversal
	//2. As you traverse, store nodes in queue.
   //3. in the end, remove from queue and store it in Linkedlist
   	
		TreeNode current = root;
	     	while(current != null) {
	     		if(current.left != null) {
	     			TreeNode temp = current.left;
	     			while(temp.right != null) {
	     				temp = temp.right;
	     			}
	     			temp.right = current.right;
	     			current.right = current.left;
	     			current.left = null;
	     		}
	     		current = current.right;
	     		}
	     	}
   	
    
}
