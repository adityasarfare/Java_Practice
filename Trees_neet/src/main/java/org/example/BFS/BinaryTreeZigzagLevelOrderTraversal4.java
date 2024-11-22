package org.example.BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal4 {
//103
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return null;
		}

		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		boolean reverse = false;
		while (!queue.isEmpty()) {
			List<Integer> currentList = new ArrayList<>();

			int level = queue.size();
			for (int i = 0; i < level; i++) {
//				1
//				3 2
//				4 5 6 7
				//Normal Order -> remove from front
//				               -> Add at back
//				reverse order  -> remove back
//				               -> Add front
				
				if (!reverse) {
					TreeNode currentNode = queue.pollFirst();
					currentList.add(currentNode.val);
					if (currentNode.left != null) {
						queue.offerLast(currentNode.left);
					}
					if (currentNode.right != null) {
						queue.offerLast(currentNode.right);
					}
				} else {
					TreeNode currentNode = queue.pollLast();
					currentList.add(currentNode.val);
					if (currentNode.right != null) {
						queue.offerFirst(currentNode.right);
					}
					if (currentNode.left != null) {
						queue.offerFirst(currentNode.left);
					}
				}		
			}
			reverse = !reverse;
					
			result.add(currentList);
		}

		return result;
	}

}
