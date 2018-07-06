
public class TreeApp {

	public static void main(String[] args) {
		Tree t1 = new Tree();
		
		t1.insert(4);
		t1.insert(6);
		t1.insert(7);
		t1.insert(1);
		t1.insert(2);
		t1.insert(40);
		
		
		t1.printPostOrder();
		
		System.out.println(t1.contains(40));
	}

}
