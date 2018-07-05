
public class LinkedListApp {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		
		ll.printAll();
		
		ll.delete(1);
		
		ll.printAll();
	}

}
