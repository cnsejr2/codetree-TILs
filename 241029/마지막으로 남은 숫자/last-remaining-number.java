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
			pq.add(-num);
		}
		while (pq.size() >= 2) {
			int n1 = -pq.poll();
			int n2 = -pq.poll();
			
			if (n1 != n2) {
				pq.add(-(n1 - n2));
			}
		}
		if (pq.size() == 1) {
			System.out.println(-pq.poll());
		} else {
			System.out.println(-1);
		}
		
		sc.close();

	}

}