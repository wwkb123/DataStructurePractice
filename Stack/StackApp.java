
public class StackApp {

	public static void main(String[] args) {
		Stack s1 = new Stack(20);
		
		for(int i=0;i<20;i++)
			s1.add(i);

		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		
	}

}
