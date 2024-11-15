package org.example;

import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {
    }

    private class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);

        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the new node to left");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the new node to right");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
    
    public void preOrder() {
    	preOrder(root);
    }
    private void preOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	
    	System.out.println(node.value + " ");
    	preOrder(node.left);
    	preOrder(node.right);
    }
    
    public void postOrder() {
    	preOrder(root);
    }
    private void postOrder(Node node) {
    	if(node == null) {
    		return;
    	}
    	
    	preOrder(node.left);
    	preOrder(node.right);
    	System.out.println(node.value+ " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.populate(scanner);
        bt.display();
    }
}
