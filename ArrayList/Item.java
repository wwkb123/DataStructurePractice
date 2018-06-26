
public class Item {
	Item next;
	String data;
	
	public Item() {
		next = null;
		data = "";
	}

	public Item(String data){
		this.data = data;
		next = null;
	}
	
	public void setData(String input){
		data = input;
	}
	
	public String getData(){
		return data;
	}
}
