import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			Long num = sc.nextLong();
			pq.add(num);
			if (pq.size() < 3) {
				System.out.println(-1);
			} else {
				Long a = pq.poll();
				Long b = pq.poll();
				Long c = pq.poll();
				
				System.out.println(a * b * c);
				pq.add(a); pq.add(b); pq.add(c);
			}
		}
		
		
		
		sc.close();

	}

}