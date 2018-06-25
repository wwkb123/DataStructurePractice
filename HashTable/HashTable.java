
public class HashTable {

	private static final int tableSize = 10;
	public Pair[] table;
	public HashTable() {
		table = new Pair[tableSize];
//		for(int i = 0;i<tableSize;i++){
//			table[i] = new Pair();
//		}
		
	}
	
	public int getIndex(String key){
		int hash = 0;
		int index;
		for(int i = 0; i<key.length();i++){
			hash = hash + (int)key.charAt(i);
		}
		index = hash % tableSize;
		return index;
	}
	
	public void putValue(String key, String value){
		Pair curr = table[getIndex(key)];
		Pair newPair = new Pair();
		newPair.key = key;
		newPair.value = value;
		if(curr==null){
			table[getIndex(key)] = newPair;
		}else{
			while(curr.next!=null){
			curr = curr.next;
			}
			curr.next = newPair;
		}
		
	}

	public String getValue(String key){
		Pair curr = table[getIndex(key)];
		while(curr.next!=null){
			if(curr.key.equals(key)){
				return curr.value;
			}else{
				curr = curr.next;
			}
		}
		return "";
		
	}
	
	public void printTable(){
		for(int i=0;i<tableSize;i++){
			Pair curr = table[i];
			if(curr==null){
				System.out.print(i);
			}else{
				System.out.print(i + " " + curr.key + " " + curr.value);
				while(curr.next!=null){
				curr = curr.next;
				System.out.print(" -> " + curr.key + " " + curr.value);
				}
			}
			
			System.out.println("");
		}
	}
	
	public int numberOfItemsInIndex(int index){
		int count = 0;
		
		Pair curr = table[index];
		if(curr==null){
			return count;
		}else{
			while(curr.next!=null){
			count++;
			curr = curr.next;
		}
		count++;
		
		return count;
		}
		
	}
}
