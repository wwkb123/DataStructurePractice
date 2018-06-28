
public class ObjectArrayListApp {

	public static void main(String[] args) {
		ObjectArrayList oal1 = new ObjectArrayList();
		
		oal1.add("String1");
		oal1.add("String2");
		oal1.add("String3");
		oal1.add("String4");
		oal1.add("String5");
		
		oal1.remove(0);
		oal1.remove(4);
		oal1.remove(3);
		
		oal1.add("a");
		oal1.add("aa");
		oal1.add("aaa");
		oal1.add("aaaa");
		oal1.add("aaaaa");
		oal1.add("aaaaaa");
		oal1.add("aaaaaaa");
		oal1.add("aaaaaaaa");
		oal1.add("aaaaaaaaa");
		oal1.add("aaaaaaaaaa");
		
		oal1.printAll();
		

	}

}
