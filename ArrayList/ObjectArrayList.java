import java.util.Arrays;

public class ObjectArrayList {

	private static final int DEFAULT_SIZE = 10;
	int size = 0;
	Object[] myArr;
	
	public ObjectArrayList() {
		myArr = new Object[DEFAULT_SIZE];
	}

	public boolean isFull(){
		return size == myArr.length;
	}
	
	public void add(Object obj){
		if(isFull()){
			int newSize = myArr.length * 2;
			myArr = Arrays.copyOf(myArr, newSize);
		}
		
		myArr[size++] = obj;
		
	}
	
	public Object get(int i){
		if(i<0 || i >=size){
			return null;
		}else{
			return myArr[i];
		}
	}
	
	public Object remove(int index){
		Object temp;
		if(index < 0 || index >=size){
			return null;
		}else{
			temp = myArr[index];
			for(int i = index;i<size-1;i++){
				myArr[i] = myArr[i+1];
			}
			size--;
			return temp;
		}
	}
	
	public void printAll(){
		for(int i = 0 ; i<size;i++){
			System.out.println(myArr[i].toString());
		}
	}
}
