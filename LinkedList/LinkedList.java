
public class LinkedList {

	Node first;
	
	public LinkedList() {
		
	}

	public void add(int data){
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
	}
	
	public void delete(int data){
		Node curr = first;
		Node prev = null;
		
		if(curr != null && curr.data == data){
			first = curr.next;
			return;
		}
		
		while(curr!=null && curr.data!= data){
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == null)return;
		
		prev.next = curr.next;
		
	}
	
	public void printAll(){
		Node curr = first;
		while(curr!=null){
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
}
