package day29;


public class BSTree {
	BE8Node root;
	BE8Node service = new BE8Node();

public BE8Node bstBuild(int[] array) {
	for (int i : array) {
		root = insertIntoTree(root,i,null);
	}
	return root;
}
	
private BE8Node insertIntoTree(BE8Node node, int value, BE8Node parent) {
	if (node == null) {
		node = new BE8Node(value);
		return node;
	}
	if (node.value < value) {
		node.hRight++;
		node.right = insertIntoTree(node.right, value, node);
	}
	else if (node.value > value) {
		node.hLeft++;
		node.left = insertIntoTree(node.left, value, node);
	}
		node = balanceBSTree(node, parent);
	return node;
	
}

public void insertArray(BE8Node node, int[] count, int[] mainArray ) {
	if (node == null) return;
	insertArray(node.right, count, mainArray);
	int currentIndex = mainArray.length - 1 - count[0];
	if (currentIndex > 0 ) {
		mainArray[currentIndex] = node.value;
		System.out.println("at index " + currentIndex + "time is equal " + mainArray[currentIndex]);
		count[0] = count[0] + 2;
	}
	insertArray(node.left, count, mainArray);
	
}



private BE8Node balanceBSTree(BE8Node node,BE8Node parent ) {
	if (node == null) return node;
	node.left = balanceBSTree(node.left, parent);
	node.right = balanceBSTree(node.right, parent);
	//check imbalance
	int leftHeight = findHeight(node.left, node);
	int rightHeight = findHeight(node.right, node);
	if (Math.abs(leftHeight - rightHeight) > 1 ) {
		node = balanceTree(node,  parent);
		
	}
	return node;
}
private BE8Node balanceTree(BE8Node node, BE8Node parent ) {
	BE8Node swap = node;
	if (node.hLeft < node.hRight) node = rotateToLeftSide(node);
	else node = rotateToRightSide(node);

	//nếu parent = null, balance xong parent = node.
	if (parent == null) {return node;}
	else {
		if (parent.left.value == swap.value) {
			parent.left = node;
		}else {
			parent.right = node;
		}

	}
	return node;
}

public BE8Node rotateToLeftSide(BE8Node node) {
	if (node.right.right == null) {
		 BE8Node toBeNode = node.right.left;
		 toBeNode.right = node.right;
		 node.right.left = null;
		 toBeNode.left = node;
		 node.right = null;
		 node = toBeNode;
		 node.right.hLeft = 0;
		 node.left.hRight = 0;
		 node.hLeft++;
		 node.hRight++;
	}
	else {
		BE8Node toBeNode = node.right;
		node.right = toBeNode.left;
		toBeNode.left = node;
		node = toBeNode;
		node.hLeft++;
		if (node.left.right == null) node.left.hRight = 0;
	}
	return node;
	

}
public BE8Node rotateToRightSide(BE8Node node) {
	if (node.left.left == null) {
		 BE8Node toBeNode = node.left.right;
		 toBeNode.left = node.left;
		 node.left.right = null;
		 toBeNode.right = node;
		 node.left = null;
		 node = toBeNode;
		 node.left.hRight = 0;
		 node.right.hLeft = 0;
		 node.hLeft++;
		 node.hRight++;
	}
	else {
		BE8Node toBeNode = node.left;
		node.left = toBeNode.right;
		toBeNode.right = node;
		node = toBeNode;
		node.hRight++;
		if (node.right.left == null) node.right.hLeft = 0;
	}

	return node;
}
private int findHeight(BE8Node node, BE8Node parent ) {
	if (node == null ) return 0; 
	if (node.left == null & node.right == null) return 1;
	int leftHeight = findHeight(node.left, node);
	int rightHeight = findHeight(node.right, node);
	return Math.max(leftHeight, rightHeight) + 1;
}

public void printByRecursion(BE8Node node) {
	if (node != null)  {
		printByRecursion(node.left);
		printByRecursion(node.right);
		System.out.println("Parent: " + node.value);
		if (node.left != null) {
			System.out.println("Children leftside: " + node.left.value);
		}; 
		if (node.right != null) {
			System.out.println("Children rightside: " + node.right.value); 
		}; 
		
		}
	}
}




