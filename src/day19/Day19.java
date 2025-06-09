package day19;

public class Day19 {
	
	public static void main(String[] args) {
		BE8LinkedList ll = new BE8LinkedList();
		LinkedListItem llItem = new LinkedListItem( );
		llItem.value = 1;
		ll.head = llItem;	
		llItem = new LinkedListItem();
		llItem.value = 18;
		ll.head.next = llItem;
		LinkedListItem llItem1 = new LinkedListItem(12);
		llItem.next = llItem1;
		LinkedListItem llItem2 = new LinkedListItem(16);
		llItem1.next = llItem2;
		LinkedListItem llItem3 = new LinkedListItem(20);
		llItem2.next = llItem3;
		LinkedListItem newIndex = insertIndex(ll.head, 53, 2);
		printAllLinkedList(ll.head);
		removeIndex(ll.head, 3);
		printAllLinkedList(ll.head);
	}
	
	public static void printAllLinkedList(LinkedListItem list) {
		System.out.println("-------------------------------");
		LinkedListItem currentList = list;
		while (currentList.next != null) {
			System.out.println("currentList is: " + currentList.value);
			System.out.println("with the next position of: " + currentList.next.value);
			currentList = currentList.next;
		}
		System.out.println("CurrentList value is: " + currentList.value);
	}
	
	public static LinkedListItem insertIndex(LinkedListItem ll, int value, int index) {
		LinkedListItem currentList = ll;
		LinkedListItem newItem = new LinkedListItem(value);
		if (ll.next == null) {
			return new LinkedListItem(0);
		}
		for (int count = 0; count < index  ; count++ ) {
			if (count != index - 1) {
				currentList = currentList.next;
			}
			else {	
				newItem.next = currentList.next;
				currentList.next = newItem;
			}
		}
		return newItem;
	}
	public static void removeIndex(LinkedListItem ll, int index) {
		LinkedListItem currentList = ll;
		for (int count = 0; count < index  ; count++ ) {		
			System.out.println(count);
			if (count != index - 1) {
				currentList = currentList.next;
			}
			else {
				LinkedListItem  deleteItem = currentList.next;
				currentList.next = currentList.next.next;	
				deleteItem.next = null;
				deleteItem.value = 0;
			}
			
		}	
		
		
	}

	

	

}
