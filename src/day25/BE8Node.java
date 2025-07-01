package day25;

import java.util.ArrayList;

public class BE8Node {
	int value;
	BE8Node left;
	BE8Node right;
	
	public BE8Node() {};
	public BE8Node(int value) {
		this.value = value;
	}

	public int findImbalance(BE8Node node,BE8Node root ) {
		if (node == null ) return 0; 
		if (node.left == null & node.right == null) return 1;
		int leftHeight = findImbalance(node.left, root);
		int rightHeight = findImbalance(node.right, root);
		if (Math.abs(leftHeight - rightHeight) > 1 ) {
			BalanceNode(node, leftHeight, rightHeight, root);
			return Math.max(leftHeight, rightHeight) - 1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public BE8Node findParentByRecursion(BE8Node node,int value, Boolean[] sides) {
		if (node == null) return null;
		BE8Node leftSide = findParentByRecursion(node.left, value, sides);
		BE8Node rightSide = findParentByRecursion(node.right, value, sides);
		if (leftSide != null) return leftSide;
		else if (rightSide != null) return rightSide;
		else if (node.left != null && node.left.value == value ) 
		{sides[0] = true; return node;}
		else if (node.right != null && node.right.value == value) 
		{sides[1] = true ; return node;}
		return null;
	}
	
	public void BalanceNode (BE8Node node, int leftHeight, int rightHeight, BE8Node root ) {
		Boolean[] sides = {false, false};
		BE8Node parent = findParentByRecursion(root, node.value, sides);
		
		BE8Node toBeSwap = node;
		if (leftHeight > rightHeight) {
			System.out.println("before rotate: " );
			printByRecursion(node);
			System.out.println("___________________________________________" );
			node = node.left;
			if (node.right != null) {
				BE8Node toBeSend = node.right;
				node.right = toBeSwap;
				node.right.left = toBeSend;
			} else {
				node.right = toBeSwap;
			}
			System.out.println("after rotate: " );
			printByRecursion(node);
			System.out.println("___________________________________________" );
		}
		else {	
			System.out.println("before rotate: " );
			printByRecursion(node);
			System.out.println("___________________________________________" );
			node = node.right;
			if (node.left != null) {
				BE8Node toBeSend = node.left;
				node.left = toBeSwap;
				node.left.right = toBeSend;
			} else {
				node.left = toBeSwap;
			}
			System.out.println("after rotate: " );
			printByRecursion(node);
			System.out.println("___________________________________________" );
		}
		if (parent != null) {
			if (sides[0]) parent.left = node;
			if (sides[1]) parent.right = node;
		}else {
	        root = node;
	    }
		
		
	}
	public BE8Node findByRecursion(BE8Node node,int value) {
		if (node == null) return null;
		BE8Node leftSide = findByRecursion(node.left, value);
		BE8Node rightSide = findByRecursion(node.right, value);
		if (leftSide != null) return leftSide;
		else if (rightSide != null) return rightSide;
		else if (node.value == value) return node;
		return null;
	}
	
	public void insertNode(BE8Node node,int value,int sides, int target) {
		BE8Node newNode = new BE8Node(value);
		BE8Node Foundednode = findByRecursion(node, target);
		if (Foundednode == null) System.out.println("Could not find nodes!");
		else {
			switch (sides) {
			case 0:
				Foundednode.left = newNode;
				break;
			case 1:
				Foundednode.right = newNode;
			}
		}
	}
	public void printByRecursion(BE8Node node) {
		if (node != null)  {
			printByRecursion(node.left);
			printByRecursion(node.right);
			System.out.println("Parent: " + node.value);
			if (node.left != null) System.out.println("Children leftside: " + node.left.value); 
			if (node.right != null) System.out.println("Children rightside: " + node.right.value);  
		}
	}
	
	
	
}
