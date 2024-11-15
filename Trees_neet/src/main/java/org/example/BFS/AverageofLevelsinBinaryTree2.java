package org.example.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree2 {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		 
		 if(root == null) {
			 return result;
		 }
		 Queue<TreeNode> queue= new LinkedList<>();
		 queue.offer(root);
		 // queue :- [1, [ 2,     3] 
		  //             [4,5]  [5,6]   ]
		 while(!queue.isEmpty()) {
			 int levelSize = queue.size();
			double average = 0;
			 for(int i=0; i<levelSize; i++) {
			     TreeNode currentNode = queue.poll();
			     average += currentNode.val;
			     if(currentNode.left!=null) {
			    	 queue.offer(currentNode.left);
			     }
			     if(currentNode.right!=null) {
			    	 queue.offer(currentNode.right);
			     }
			 }
			 average = average/levelSize;
			result.add(average);	
		 }
		 return result;
}
}
