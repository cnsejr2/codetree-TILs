import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr = new int[1000001];
	static int[] visit = new int[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		bfs();
		
		System.out.println(visit[n]);
		
		sc.close();

	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 1; i <= 4; i++) {
				int next = cur;
				if (i == 1) {
					next--;
				} else if (i == 2) {
					next++;
				} else if (i == 3) {
					if (next % 2 == 0) {
						next /= 2;
					} else {
						continue;
					}
				} else if (i == 4) {
					if (next % 3 == 0) {
						next /= 3;
					} else {
						continue;
					}
				}
				if (next > 0) {
					if (next == 1) {
						return;
					} else {
						visit[next] = visit[cur] + 1;
						q.add(next);
					}
				}
				
				
			}
		}
		
		
	}

}