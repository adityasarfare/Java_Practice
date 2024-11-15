package org.example;

import java.util.Scanner;

public class BST {
	 public BST() {
	    }

	    private class Node {
	        int value;
	        Node right;
	        Node left;
	        int height;

	        public Node(int value) {
	            this.value = value;
	        }
	        
	        public int geValue() {
	        	return value;
	        }
	    }

	    private Node root;
	    
	    public int height(Node node) {
	    	if(node == null) {
	    	return	-1;
	    	}
	    	
	    	return node.height;
	    }
	    
	    public boolean isEmpty() {
	    	return root == null;
	    }
	    
//	    {15, 2, 7, 1, 4, 6, 9, 8, 3, 10}
	    public void insert(int value) {
	    	root = insert(value, root);
	    }
	    
	    public Node insert(int value, Node node) {
	    	if(node == null) {
	    		node = new Node(value);
	    		return node;
	    	}
	    	
	    	if(value < node.value) {
	    		node.left = insert(value, node.left);
	    	}
	    	

	    	if(value > node.value) {
	    		node.right = insert(value, node.right);
	    	}
	    	
	    	node.height = Math.max(height(node.left), height(node.right)) + 1;
	    	return node;
	    }
	    
	    public boolean balanced() {
	    	return balanced(root);
	    }
	    
	    private boolean balanced(Node node) {
	    	if(node == null) {
	    		return true;
	    	}
	    	
	    	return Math.abs(height(node.left) - height(node.right))<=1 && balanced(node.left) && balanced(node.right);
	    }
	    
	    public void display () {
	    	display (this.root, "Root Node: ");
	    	
	    }

		private void display(Node node, String details) {
			if(node == null) {
				return;
			}
			
			System.out.println(details + node.value);
			display(node.left, "Left child of " + node.value + " : ");
			display(node.right, "Right child of " + node.value + " : ");
			
		}
		
		 public static void main(String[] args) {
		       
		        BST bt = new BST();
		        int [] nums = {15, 2, 7, 1, 4, 6, 9, 8, 3, 10};
		        bt.populate(nums);
		        bt.display();
		    }

		private void populate(int[] nums) {
			for(int i =0; i<nums.length; i++) {
				this.insert(nums[i]);
			}
			
		}
	    
}
