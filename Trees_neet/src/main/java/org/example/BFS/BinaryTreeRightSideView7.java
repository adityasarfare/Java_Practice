package org.example.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//199
public class BinaryTreeRightSideView7 {

	 public List<Integer> rightSideView(TreeNode root) {
	        
      List<Integer> result = new ArrayList<>();
		 
		 if(root == null) {
			 return result;
		 }
		 Queue<TreeNode> queue= new LinkedList<>();
		 queue.offer(root);
		 // queue :- [1, [ 2,     3] 
		  //             [4,5]  [5,6]   ]
		 while(!queue.isEmpty()) {
			 int levelSize = queue.size();
	
			 for(int i=0; i<levelSize; i++) {
			     TreeNode currentNode = queue.poll();
			   
			     if(i == levelSize-1) {
			    	 result.add(currentNode.val);
			     }
			     
			     if(currentNode.left!=null) {
			    	 queue.offer(currentNode.left);
			     }
			     if(currentNode.right!=null) {
			    	 queue.offer(currentNode.right);
			     }
			 }


				
		 }
		 return result;
	    }
}
