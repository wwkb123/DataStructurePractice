
public class ArrayList {
	
	int nElem;
	Item first;
	public ArrayList() {
		nElem=0;
		first=null;
	}

	void add(String data){
		if(first==null){
			first = new Item(data);
			nElem++;
		}else{
			Item curr = first;
			while(curr.next!=null){
				curr = curr.next;
			}
			curr.next = new Item(data);
			nElem++;
		}
	}
	
	void add(int index, String data){
		if((first==null||index>nElem)&&index!=0){
			return;
		}else if(first ==null&&index==0){
			first = new Item(data);
			nElem++;
		}else if (index == 0){
			Item newItem = new Item(data);
			newItem.next = first;
			first = newItem;
			nElem++;
		}else{
			Item curr = first;
			for(int i = 0;i<index-1;i++){
				curr = curr.next;
			}
			Item newItem = new Item(data);
			if(curr.next!=null){
				newItem.next = curr.next;
			}
			curr.next = newItem;
			nElem++;
		}
	}
	
	String get(int index){
		if(nElem>index){
			Item curr = first;
			for(int i=0;i<index;i++){
				curr = curr.next;
			}
			return curr.getData();
		}else{
			return "";
		}
	}
	
	void remove(int index){
		if(index>nElem-1 &&index!=0||nElem==0){
			return;
		}else{
			Item curr = first;
			for(int i = 0;i<index-1;i++){
				curr = curr.next;
			}
			if(nElem==1){
				curr = null;
			}else if(index==0){
				first = first.next;
			}else if(curr.next.next!=null){
				curr.next = curr.next.next;
			}else{
				curr.next = null;
			}
			nElem--;
		}
	}
	
	void printAll(){
		Item curr = first;
		if(curr==null){
			return;
		}
		while(curr.next!=null){
			System.out.println(curr.getData());
			curr = curr.next;
		}
		System.out.println(curr.getData());
	}
	
}
