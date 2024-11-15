package org.example;

import java.util.Scanner;

public class AVL {
	
	 public AVL() {
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
	    
	    public int height() {
	        return height(root);
	      }
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
	    	return rotate(node);
	    }
	    
	    private Node rotate(Node node) {
			if(height(node.left) -  height(node.right) > 1) {
			// left heavy
				if(height(node.left.left) - height(node.left.right)>0 ) {
					// left left case
					rightRotate(node.left);
				}
				if(height(node.left.left) - height(node.left.right)< 0 ) {
					// left right case
					node.left = leftRotate(node.right); 
					rightRotate(node);
				}
			}
			
			if(height(node.left) -  height(node.right) < -1) {
				// right heavy
					if(height(node.right.left) - height(node.right.right) < 0 ) {
						// right right case
						leftRotate(node.right);
					}
					if(height(node.right.left) - height(node.right.right) > 0) {
						// right left  case
						node.left = rightRotate(node.right); 
						leftRotate(node);
					}
				}
			return node;
		}

		

		private Node rightRotate(Node p) {
			
			Node c = p.left;
			Node t = c.right;
			 c.right = p;
			 p.left = t;
			 
			 p.height = Math.max(height(p.left), height(p.right)) + 1;
			 c.height = Math.max(height(c.left), height(c.right)) + 1;
			 
			 return c;
		}
		private Node leftRotate(Node c ) {
			Node p = c.right;
			Node t = p.left;
			 p.left = c;
			 c.right = t;
			 
			 p.height = Math.max(height(p.left), height(p.right)) + 1;
			 c.height = Math.max(height(c.left), height(c.right)) + 1;
			return p;
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

		private void populate(int[] nums) {
			for(int i =0; i<nums.length; i++) {
				this.insert(nums[i]);
			}
		}
		
		 public static void main(String[] args) {
		       
		        AVL avl = new AVL();
//		        int [] nums = {15, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//		        avl.populate(nums);
//		        avl.display();
		        
		        for(int i=0; i < 1000; i++) {
		        	avl.insert(i);
		        }
		        System.out.println(avl.height());
		    }

		        
			
		
	    
}
