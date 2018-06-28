
public class Queue {

	int[] myArr;
	int size;
	int head;
	int tail;
	
	public Queue() {
		size = 10;
		myArr = new int[size];
		head = -1;
		tail = 0;
	}
	
	public Queue(int size_input){
		size = size_input;
		myArr = new int[size];
	}
	
	public void add(int input){
		myArr[tail++] = input;
		if(tail==size){
			tail = 0;
		}
	}

	public int remove(){
		int result = myArr[head++];
		if(head == size){
			head = 0;
		}
		return result;
	}
	
}
