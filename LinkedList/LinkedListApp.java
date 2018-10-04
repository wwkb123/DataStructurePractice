public class LinkedListApp{

	public static class LinkedList{
		Node head;
		int size = 0;

		public LinkedList(){
			head = null;
			size = 0;
		}

		public void insertFront(int data){
			Node n = new Node(data);
			if(head==null){
				head = n;
			}
			else{
				n.next = head;
				head = n;
			}
			size++;
		}

		public void insertBack(int data){
			Node n = new Node(data);
			if(head==null){
				head = n;
			}
			else{
				Node curr = head;
				while(curr.next != null){
					curr = curr.next;
				}
				curr.next = n;
			}
			size++;
		}

		public Node removeFront(){
			if(head==null) return null;
			Node temp = head;
			head = head.next;
			size--;
			return temp;
		}

		public Node removeBack(){
			if(head==null) return null;
			Node curr = head;
			Node prev = head;
			while(curr.next != null){
				prev = curr;
				curr = curr.next;
			}
			Node temp = curr;
			prev.next = null;
			return temp;
		}
		
		public Node removeAt(int index){
			if(head == null || index < 0 || index >= size) return null;
			if(index == 0){
				Node temp = head;
				head = head.next;
				return temp;
			}
			Node curr = head;
			Node prev = head;
			for(int i = 0; i < index && curr.next != null; i++){
				prev = curr;
				curr = curr.next;
			}
			Node temp = curr;
			prev.next = curr.next;
			return temp;
		}

		public Node replaceNode(int index, int data){
			if(head == null || index < 0 || index >= size) return null;
			Node newNode = new Node(data);
			if(index == 0){
				Node temp = head;
				newNode.next = head.next;
				head = newNode;
				return temp;
			}
			Node curr = head;
			Node prev = head;
			for(int i = 0; i < index && curr.next != null; i++){
				prev = curr;
				curr = curr.next;
			}
			Node temp = curr;
			newNode.next = curr.next;
			prev.next = newNode;
			return temp;
		}
		
		public Node getNode(int data){
			if(head==null){
				return null;
			}
			else{
				Node curr = head;
				while(curr.next != null){
					if(curr.data == data) return curr;
					curr = curr.next;
				}
				return (curr.data==data)?curr:null;
			}
		}

		public void deleteMiddle(Node n){
			Node temp = n.next;
			n.data = temp.data;
			n.next = temp.next;
			temp = null;
		}
		
		public void reverseList(){
			if(head == null) return;
			Node next = null;
			Node curr = head;
			Node prev = null;
			while(curr != null){
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			head = prev;
		}

		public void printAll(){
			if(head == null){
				return;
			}
			else{
				Node curr = head;
				while(curr.next != null){
					System.out.print(curr.data+"->");
					curr = curr.next;
				}
				System.out.print(curr.data+"\n");
			}
		}		
	}


	public static class Node{
		Node next;
		int data;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args){
		LinkedList ll = new LinkedList();

		ll.insertBack(1);
		ll.insertBack(2);
		ll.insertBack(3);
		ll.insertBack(4);
		ll.insertBack(5);

		ll.printAll();

		ll.deleteMiddle(ll.getNode(3));
		ll.removeFront();
		ll.removeFront();
		ll.removeFront();
		ll.insertBack(22);
		ll.insertBack(69);
		ll.insertBack(11);
		ll.removeBack();
		ll.printAll();

		ll.reverseList();
		ll.printAll();
	}
}
