import java.util.Hashtable;

public class App {

	public static void main(String[] args) {
		HashTable table1 = new HashTable();
		table1.putValue("Tommy", "123456");
		table1.putValue("Eva", "12132131");
		table1.putValue("JR", "999");
		table1.putValue("aa", "999");
		table1.putValue("JssR", "999");
		table1.putValue("JbbR", "999");
		table1.putValue("asdf", "999");
		table1.printTable();

		
		System.out.println(table1.getValue("Eva"));
		
		Hashtable<String,String> table2 = new Hashtable<String,String>();
		
		table2.put("Evabb", "520");
		table2.put("Tommy", "1314");
		System.out.println(table2.get("Tommy"));
		
	}

}
