import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		double max = Double.MIN_VALUE;
		for (int i = 0; i < n - 2; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int j = i; j < n; j++) {
				pq.add(arr[j]);
			}
			pq.poll();
			int sum = 0;
			double cnt = pq.size();
			while (!pq.isEmpty()) {
				sum += pq.poll();
			}
			max = Math.max(max, sum / cnt);
		}
		System.out.printf("%.2f", max);
		
		sc.close();

	}

}