import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			
			if (str.equals("push")) {
				int num = sc.nextInt();
				pq.add(num);
			} else if (str.equals("pop")) {
				System.out.println(pq.poll());
			} else if (str.equals("size")) {
				System.out.println(pq.size());
			} else if (str.equals("empty")) {
				if (pq.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
 			} else if (str.equals("top")) {
 				System.out.println(pq.peek());
			}
			
		}
		
		
		sc.close();

	}

}