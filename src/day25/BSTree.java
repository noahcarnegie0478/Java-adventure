package day25;

public class BSTree {
	BE8Node root;
	BE8Node service = new BE8Node();
	
//
//
//	           
//	           
//	         6   
//	       /   \    
//	      3     9  
//	     / \   / \      
//	    2   5 8   10      
//	   / \         \
//	  1   4        23
//
//kịch bản sẽ là như này: 
//
//cho mảng: {1,5,3,6,8,9,10,23,2,4}
//
//bắt đầu sẽ có 2 bước chính là insert và balance: 
//
//điều kiện của insert là: 
//value bé hơn node thì qua trái
//value lớn hơn node thì qua phải
//nó sẽ đi đến khi nào mà nó gặp được tận cùng thì nó sẽ gắn giá trị ở đó
//sau đó đến balance:
//

//
//như vậy flow bài này sẽ là như sau: 
//
//Node = 1, root đang bằng null => root = 1, trả về node = 1;
//Node = 5, root đang bằng 1 => tree vẫn balance, trả về  1 right 5
//node = 3, root đang bằng 1 => tree imbalnce, trả về 1 right 5, 5 left 3. => balance lại thành 5 left 1 right 3 =>. sai quy luật 3. tra công thức nếu node lớn hơn phải và lớn hơn cả trái, thì xem trái và phải cái nào lớn hơn, nếu phải vẫn lớn hơn, thì phải lên node xuống. => balance =>  1-3-5.
//node = 6, root = 3 => balance => tầng 1: 1-3-5, tằng 2 6 là right của 5.
//node 8, root = 3, imbalance => tầng 1: 1-3-5, tângf 2 6, tầng 3 8. chuẩn điều kiện trái bé, phải lớn =>. root ko đổi. 
//node = 9, root = 3, imbalance => đẩy 6 lên, do tại lệch 2 node, 5 sẽ được gán vào 3. 
//node = 10, root = 6, imbalance => đẩy 9 lên làm node, 8 sang left, 10 sang right. 

public BE8Node bstBuild(int[] array) {
	//mang {5,4,3}
	for (int i : array) {
		root = insertIntoTree(root,i);
		root = balanceBSTree(root, null);
	}
	
//	service.printByRecursion(root);
	System.out.println("-------------------------------- after all ---------------------------");
//	System.out.println("parent: " + root.value);
//	if (root.left != null) System.out.println("left: " + root.left.value);
//	if (root.right != null) System.out.println("right: " + root.right.value);
	
	System.out.println("-------------------------------- after all ---------------------------");
	return root;
}
	
private BE8Node insertIntoTree(BE8Node node, int value) {
	if (node == null) {
		node = new BE8Node(value);
		return node;
	}
	if (node.value < value) {
		node.right = insertIntoTree(node.right, value);
	}
	else if (node.value > value) {
		node.left = insertIntoTree(node.left, value);
	}
	//điều kiện của insert là: 
	//value bé hơn node thì qua trái
	//value lớn hơn node thì qua phải
	//nó sẽ đi đến khi nào mà nó gặp được tận cùng thì nó sẽ gắn giá trị ở đó
	//sau đó đến balance:
	return node;
	
	
	
}
private BE8Node balanceBSTree(BE8Node node,BE8Node parent ) {
	//điều kiện của balance là: 
	//Node khác null, nếu bằng null return node;
	
	if (node == null) return node;
	
	//check imbalance
	int leftHeight = findHeight(node.left, node);
	int rightHeight = findHeight(node.right, node);
	if (Math.abs(leftHeight - rightHeight) > 1 ) {
		System.out.println("-------------------------------- before balance ---------------------------");
		System.out.println("parent: " + node.value);
		if (node.left != null) System.out.println("left: " + node.left.value);
		
		if (node.right != null) System.out.println("right: " + node.right.value);
		System.out.println("-------------------------------- before balance ---------------------------");
		node = balanceTree(node, leftHeight, rightHeight, parent);
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
	}
	else {
		BE8Node toBeNode = node.right;
		node.right = toBeNode.left;
		toBeNode.left = node;
		node = toBeNode;
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
	}
	else {
		BE8Node toBeNode = node.left;
		node.left = toBeNode.right;
		toBeNode.right = node;
		node = toBeNode;
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
private BE8Node balanceTree(BE8Node node, int left, int right,BE8Node parent ) {
	BE8Node swap = node;
	//nếu lệch trái, xoay phải
	if (left < right) node = rotateToLeftSide(node);
	//nếu lệch phải, xoay trái
	else node = rotateToRightSide(node);
	
	System.out.println("---------------------after balance -------------------------------");
	System.out.println("parent: " + node.value);
	System.out.println("left: " + node.left.value);
	System.out.println("right: " + node.right.value);
	System.out.println("---------------------after balance -------------------------------");
	//nếu parent = null, balance xong parent = node.
	if (parent == null) {return node;}
	else {
		if (parent.left.value == swap.value) {
			parent.left = node;
		}else {
			parent.left = node;
		}
	}
	 
	return node;
	
}
private BE8Node nodeIsLessthanLeftAndRight(BE8Node node) {
	BE8Node swap = node;
	//1. nếu bên trái lớn hơn node, bên phải lớn hơn node thì kiểm tra xem bên phải có lớn hơn bên trái ko, nếu có… hoán đổi vị trí của node và trái
	if (node.right.value > node.left.value) {
		node = node.left;
		node.left = swap;
	}
	//2. nếu bên phải bé hơn bên trái, và trái phải đều lớn hơn node, thì đổi phải lên node, trái qua phải.
	else {
		node = node.right;
		node.left = swap;
		node.right = swap.left;
		
	}
	return node;
	
}
private BE8Node nodeIsMorethanLeftAndRight(BE8Node node) {
	//3. nếu node lớn hơn phải và lớn hơn trái, so sánh xem node trái và phải cáí nào lớn hơn, nếu bên trái lớn hơn, thì phải qua trái, trái lên node, node qua phải.
	System.out.println("node is big run!");
	BE8Node swap = node;
	if (node.right.value > node.left.value ) { 
		node = node.right;
		node.right = swap;
		node.left = swap.left;
	}else {
		node = node.left;
		node.right = swap;
		node.left = swap.right;
	}
	System.out.println("---------------------after swap -------------------------------");
	System.out.println("parent: " + node.value);
	System.out.println("left: " + node.left.value);
	System.out.println("right: " + node.right.value);
	
	System.out.println("---------------------after swap -------------------------------");
	return node;
	
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
