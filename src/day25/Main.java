package day25;

public class Main {
	public static void main(String[] args) {
		BE8Node service = new BE8Node();
		int left = 0;
		int right = 1;
		BE8Root root = new BE8Root();
		BE8Node node = new BE8Node();
		node.value = 1;
		root.root = node;
		node = new BE8Node(2);
		root.root.left = node;
		service.insertNode(root.root, 6, right, root.root.value);
		service.insertNode(root.root, 3, left, 2);
		service.insertNode(root.root, 7, right, 2);
		service.insertNode(root.root, 4, left, 3);
		service.insertNode(root.root, 5, right, 3);
		service.insertNode(root.root, 9, right, 4);
		service.findImbalance(root.root,root.root );
		service.printByRecursion(root.root);

		
		
		
		
		
		
	}

}
