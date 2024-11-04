import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
					
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < m; i++) {
				int num = sc.nextInt();
				for (int j = 0; j < n; j++) {
					pq.add(num + arr[j]);
				}
				
			}
			int i = 1;
			while (i < k) {
				pq.poll();
				i++;
			}
			System.out.println(pq.poll());
			
			sc.close();
		
	}

}