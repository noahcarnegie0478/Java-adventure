package day29;

import java.util.ArrayList;

public class BE8Node {
	int value;
	BE8Node left;
	BE8Node right;
	int hLeft;
	int hRight;
	public BE8Node() {};
	public BE8Node(int value) {
		this.value = value;
		this.hLeft = 0;
		this.hRight = 0;
	}	
	public void BalanceNode (BE8Node node, int leftHeight, int rightHeight, BE8Node parent ) {
		BE8Node toBeSwap = node;
		if (leftHeight > rightHeight) {
			node = node.left;
			if (node.right != null) {
				BE8Node toBeSend = node.right;
				node.right = toBeSwap;
				node.right.left = toBeSend;
			} else {
				node.right = toBeSwap;
			}

		}
		else {	
			node = node.right;
			if (node.left != null) {
				BE8Node toBeSend = node.left;
				node.left = toBeSwap;
				node.left.right = toBeSend;
			} else {
				node.left = toBeSwap;
			}
		}
		if (parent.left.value == toBeSwap.value) parent.left = node;
		else parent.right = node;
		
		
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
