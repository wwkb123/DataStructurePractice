
public class QueueApp {

	public static void main(String[] args) {
		
		Queue q1 = new Queue(20);
		for(int i = 0;i<20;i++){
			q1.add(i);
		}

		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		
		q1.add(21);
		q1.add(22);
		q1.add(23);
		q1.add(24);
		q1.add(25);
		
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
	
	}

}
