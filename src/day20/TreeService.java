package day20;

import java.util.ArrayList;

public class TreeService {
	
	public void insertTree(BE8Tree root, Integer newValue,Integer parent) {
		ArrayList<BE8Tree> nodeCollection = new ArrayList<BE8Tree>();
		nodeCollection.add(root);
		
		BE8Tree tobeInsert = new BE8Tree();
		
		if (nodeCollection.get(0).value == parent) {
			tobeInsert = nodeCollection.get(0);
			tobeInsert.children.add(new BE8Tree(newValue));
		}
		
		while (tobeInsert.value != parent & nodeCollection.size() > 0) {
			ArrayList<BE8Tree> currentParent = nodeCollection.get(0).children;
			if (currentParent!= null) {
				for (int i = 0; i < currentParent.size(); i++) {
					if (currentParent.get(i).value == parent) {
						tobeInsert = currentParent.get(i);
						tobeInsert.children.add(new BE8Tree(newValue));
						break;
					}
					nodeCollection.add(nodeCollection.get(0).children.get(i));
				}
			}
			nodeCollection.remove(0);
		}
	}
	
	
	public void printTree(BE8Tree root) {
		ArrayList<BE8Tree> nodeCollection = new ArrayList<BE8Tree>();
		nodeCollection.add(root);
		while (nodeCollection.size() > 0) {
			System.out.println("Parent is: " + nodeCollection.get(0).value); 
			if (nodeCollection.get(0).children != null) {
				for (int i = 0; i < nodeCollection.get(0).children.size(); i++) {
					System.out.println("And the child: "+nodeCollection.get(0).children.get(i).value);
					nodeCollection.add(nodeCollection.get(0).children.get(i));
				}
			}
			nodeCollection.remove(0);
		}

		
		
	}
	

}
