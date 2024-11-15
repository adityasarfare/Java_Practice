package org.example;

import java.util.Scanner;

public class BSTSortedeArray {
	 public BSTSortedeArray() {
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
	    
	    public void populateSorted(int[] nums) {
	    	populateSorted(nums, 0, nums.length);
	    }
	    
	    public void populateSorted(int[] nums, int start, int end) {
	    	if(start >= end) {
	    		return;
	    	}
	    	
	    	int m = (start + end)/2;
	    	insert(nums[m]);
	    	populateSorted(nums, start, m);
	    	populateSorted(nums, m+1, end);
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
		       
		        BSTSortedeArray bt = new BSTSortedeArray();
		        int [] nums = {1,2,3,4,5,6,7,8,9,10};
//		        bt.populate(nums);
		        bt.populateSorted(nums);
		        bt.display();
		    }

		private void populate(int[] nums) {
			for(int i =0; i<nums.length; i++) {
				this.insert(nums[i]);
			}
			
		}
	    
}
