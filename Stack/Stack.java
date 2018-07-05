
public class Stack {

	int[] myArr;
	int size;
	int top;
	
	public Stack() {
		size = 10;
		myArr = new int[size];
		top = -1;
	}
	
	public Stack(int size){
		this.size = size;
		myArr = new int[this.size];
		top = -1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void add(int input){
		top++;
		if(top<size)
			myArr[top] = input;
		else
			top--;
	}
	
	public Integer pop(){
		if(!isEmpty())
			return myArr[top--];
		else
			return null;
	}

	public Integer peak(){
		if(!isEmpty())
			return myArr[top];
		else
			return null;
	}
}
