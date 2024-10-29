import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = new int[n];
		double sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			pq.add(arr[i]);
			sum += arr[i];
		}
		double max = Double.MIN_VALUE;
		for (int i = 0; i < n - 2; i++) {
			sum -= arr[i];
			pq.remove(arr[i]);
			int min = pq.peek();
			sum -= min;
			max = Math.max(max, sum / (pq.size() - 1));
			sum += min;
		}
		System.out.printf("%.2f", max);
		
		sc.close();

	}

}