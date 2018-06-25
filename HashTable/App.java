
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

		
		System.out.print(table1.getValue("Eva"));
	}

}
