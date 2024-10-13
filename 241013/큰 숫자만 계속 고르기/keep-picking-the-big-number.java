import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			pq.add(-num);
		}
		for (int i = 0; i < m; i++) {
			int num = -pq.poll();
			num -= 1;
			pq.add(-num);
		}
		System.out.println(-pq.peek());
		sc.close();

	}

}