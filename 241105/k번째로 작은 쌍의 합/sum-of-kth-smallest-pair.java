import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			int[] arr1 = new int[n];
			for (int i = 0; i < n; i++) {
				arr1[i] = sc.nextInt();
			}
			Arrays.sort(arr1);
					
			int[] arr2 = new int[m];
			for (int i = 0; i < m; i++) {
				arr2[i] = sc.nextInt();
			}
			Arrays.sort(arr2);
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			    return (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]]);
			});

			for(int i = 0; i < n; i++) {
			    pq.offer(new int[] {i, 0});
			}

			int[] cur = new int[2];
			while(k-- > 0) {
			    cur = pq.poll();
				if(cur[1] < m - 1)
			          pq.offer(new int[] {cur[0], cur[1] + 1});
			};

			System.out.println(arr1[cur[0]] + arr2[cur[1]]);
			
			
			sc.close();
		
	}

}