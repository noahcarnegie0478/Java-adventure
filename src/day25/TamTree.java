package day25;

import java.util.*;

public class TamTree  {
	BE8Node root;

	public int getHeight() {
		return height(root);
	}
	
	public int height(BE8Node node) {
		if (node == null) return -1;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	// ====== DSA Day 8+9: Balance Tree ====== //
	public void balanceTree() {
		balanceTreeRecursion(null, root);
	}
	
	private int[] balanceTreeRecursion(BE8Node parentNode, BE8Node node) {
		if (node == null) return new int[]{-1, -2, -2};
		
		// Calculate height of each sub-tree
		// Return array should be: [height, left height, right height]
		int[] leftTreeHeight = balanceTreeRecursion(node, node.left); 
		int[] rightTreeHeight = balanceTreeRecursion(node, node.right);
		
		// Check imbalance node & rotate
		int[] returnedTreeHeight = new int[3];
		if (Math.abs(leftTreeHeight[0] - rightTreeHeight[0]) > 1) {
			if (leftTreeHeight[0] > rightTreeHeight[0]) {
				// Rotate right & update height
				rotateRight(parentNode, node, leftTreeHeight);
				
				// Left height always decrease by 1
				returnedTreeHeight[1] = leftTreeHeight[0] - 1;
				// Right height may increase by 1 or 2, depending on the hRight of node.left (leftTree[2])
				returnedTreeHeight[2] = Math.max(rightTreeHeight[0], leftTreeHeight[2]) + 1;
			} else {
				// Rotate left & update height
				rotateLeft(parentNode, node, rightTreeHeight);
				
				returnedTreeHeight[1] = Math.max(leftTreeHeight[0], rightTreeHeight[1]) + 1;
				returnedTreeHeight[2] = rightTreeHeight[0] - 1;
			}
		} else {
			returnedTreeHeight[1] = leftTreeHeight[0];
			returnedTreeHeight[2] = rightTreeHeight[0];
		}

		// Calculate height
		returnedTreeHeight[0] = Math.max(returnedTreeHeight[1], returnedTreeHeight[2]) + 1;
 		return returnedTreeHeight;
	}
	
	private void rotateRight(BE8Node parentNode, BE8Node node, int[] leftTreeHeight) {
		BE8Node rotatedNode = node.left;
		// leftTreeHeight[1] is hLeft, leftTreeHeight[2] is hRight of left subtree (node.left)
		if (leftTreeHeight[1] >= leftTreeHeight[2]) {
			node.left = rotatedNode.right;
			rotatedNode.right = node;
		} else {
			node.left = rotatedNode.left;
			rotatedNode.left = rotatedNode.right;
			rotatedNode.right = node;

			// We swapped the children of the rotatedNode (node.left) -> must update the height 
			int tmp = leftTreeHeight[1];
			leftTreeHeight[1] = leftTreeHeight[2];
			leftTreeHeight[2] = tmp;
		}
		
		// Update parent's child node
		if (parentNode == null) {
			root = rotatedNode;
		} else if (parentNode.left.value == node.value) {
			parentNode.left = rotatedNode;
		} else {
			parentNode.right = rotatedNode;
		}
	}
	
	private void rotateLeft(BE8Node parentNode, BE8Node node, int[] rightTreeHeight) {
		BE8Node rotatedNode = node.right;
		// rightTreeHeight[1] is hLeft, rightTreeHeight[2] is hRight of right subtree (node.right)
		if (rightTreeHeight[2] >= rightTreeHeight[1]) {
			node.right = rotatedNode.left;
			rotatedNode.left = node;
		} else {
			node.right = rotatedNode.right;
			rotatedNode.right = rotatedNode.left;
			rotatedNode.left = node;
			
			// We swapped the children of the rotatedNode (node.right) -> must update the height 
			int tmp = rightTreeHeight[1];
			rightTreeHeight[1] = rightTreeHeight[2];
			rightTreeHeight[2] = tmp;
		}
		
		// Update parent's child node
		if (parentNode == null) {
			root = rotatedNode;
		} else if (parentNode.left.value == node.value) {
			parentNode.left = rotatedNode;
			
		} else {
			parentNode.right = rotatedNode;
		}
	}
	
	// ====== DSA Day 7: Check balance and find imbalance node ====== //
	// Check balance
	public boolean isBalance() {
		return checkBalanceWithHeight(root) != -1;
	}
	
	private int checkBalanceWithHeight(BE8Node node) {
		if (node == null) return 0;
		
		// Calculate height & check imbalance of child node
		// h = -1 => imbalance
		int h1 = checkBalanceWithHeight(node.left);
		if (h1 == -1) return -1;
		
		int h2 = checkBalanceWithHeight(node.right);
		if (h2 == -1) return -1;
		
		// Check imbalance of  current node 
		// |h1 - h2| > 1 => return -1 for imbalance
		if (Math.abs(h1-h2) > 1) return -1;
		
		// Return current level
		return Math.max(h1, h2) + 1;
	}
	
	// Find imbalance node
	public ArrayList<BE8Node> findImbalanceNode() {
		ArrayList<BE8Node> result = new ArrayList<BE8Node>();
		findImbalanceWithHeight(result, root);
		
		return result;
	}
	
	private int findImbalanceWithHeight(ArrayList<BE8Node> nodeList, BE8Node node) {
		if (node == null) return -1;
		
		// Calculate height
		int h1 = findImbalanceWithHeight(nodeList, node.left);
		int h2 = findImbalanceWithHeight(nodeList, node.right);
		
		// Check imbalance node
		// if |h1 - h2| > 1 => this node is imbalance => add to list
		if (Math.abs(h1-h2) > 1) {
			nodeList.add(node);
		}
		
		// Calculate height
		return Math.max(h1, h2) + 1;
	}
}
