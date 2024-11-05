import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			pq.add(num);
			if (pq.size() < 3) {
				System.out.println(-1);
			} else {
				int a = pq.poll();
				int b = pq.poll();
				int c = pq.poll();
				
				System.out.println(a * b * c);
				pq.add(a); pq.add(b); pq.add(c);
			}
		}
		
		
		
		sc.close();

	}

}