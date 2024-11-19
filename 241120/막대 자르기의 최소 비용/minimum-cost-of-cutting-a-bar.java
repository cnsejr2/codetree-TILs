import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<Long>();

		for (int i = 0; i < n; i++) {
			long num = sc.nextLong();
			pq.add(num);
		}
		long ans = 0;
		while (pq.size() > 1) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			pq.add(n1 + n2);
			ans += (n1 * n2);
		}
		System.out.println(ans);
		
		sc.close();

	}

}
