
public class ArrayListApp {

	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();
		
		al1.add("Tommy");
		al1.add("Eva");
		al1.add("Ave");
		al1.add("yy");
		al1.add("gg");

		al1.remove(4);
		al1.add(4, "Land");
		al1.printAll();

		System.out.print(al1.get(4));
	}

}
