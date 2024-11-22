package org.example.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.example.BFS.TreeNode;

public class SerializeandDeserializeBinaryTree11 {

	 public List<String> serialize(TreeNode root) {
	        List<String> list = new ArrayList<>();
	        
	        helper(root, list);
	        return list;
	    }

	   private void helper(TreeNode node, List<String> list) {
		   if(node == null) {
			   list.add("null");
			   return;
		   }
		   list.add(String.valueOf(node.val));
		   
		   helper(node.left, list);
		   helper(node.right, list);
	}
	   
	   public TreeNode deserialize(List<String> list) {
	       TreeNode node = helper2(list);
	       return node;
	    }

	private TreeNode helper2(List<String> list) {
		
		Collections.reverse(list);
		String s = list.remove(list.size()-1);
		
		if(s.charAt(0) == 'n') {
			return null;
		}
			TreeNode node = new TreeNode(Integer.parseInt(s));
			
			node.left = helper2(list);
			node.right = helper2(list);
			
		return node;
	}
	
	///////////////////////////////////////
	
	
	public String serialize1(TreeNode root) {
//        List<String> list = new ArrayList<>();
		StringBuilder s = new StringBuilder();
        
        helper(root, s);
        return s.toString();
    }

   private void helper(TreeNode node, StringBuilder s) {
	   if(node == null) {
		   s.append("null,");
		   return;
	   }
//	   list.add(String.valueOf(node.val));
	   s.append(node.val).append(",");
	   helper(node.left, s);
	   helper(node.right, s);
}
   
   public TreeNode deserialize2(String s) {
	   String[] nodes = s.split(",");
	   ArrayList<String> list = new ArrayList<>(Arrays.asList(nodes));
	   
       TreeNode node = helper3(list);
       return node;
    }

   private TreeNode helper3(List<String> list) {
	
//	Collections.reverse(list);
	String s = list.remove(0);
	
	if(s.charAt(0) == 'n') {
		return null;
	}
		TreeNode node = new TreeNode(Integer.parseInt(s));
		
		node.left = helper2(list);
		node.right = helper2(list);
		
	return node;
}
}
