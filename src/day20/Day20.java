package day20;
import java.util.*;

public class Day20 {	
	public static void main(String[] args) {
		BE8Root root = new BE8Root();
		BE8Tree node = new BE8Tree();
		TreeService treeService = new TreeService();
		node.value = 52;
		root.root = node;
		node = new BE8Tree();
		node.value = 60;
		root.root.children.add(node);
		node = new BE8Tree();
		node.value = 75;
		root.root.children.add(node);	
		treeService.insertTree(root.root, 90, 60);
		treeService.insertTree(root.root, 87, 60);
		treeService.insertTree(root.root, 61, 60);
		treeService.insertTree(root.root, 55, 75);
		treeService.insertTree(root.root, 24, 75);
		treeService.insertTree(root.root, 26, 75);
		treeService.insertTree(root.root, 5, 87);
		treeService.printTree(root.root);
	}
		
}
