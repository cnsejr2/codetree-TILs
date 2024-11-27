import java.util.Scanner;

public class Main {

	public static final int MAX_N = 100;
	public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
	public static boolean[] visited = new boolean[MAX_N + 1];
	
	public static int[] dist = new int[MAX_N + 1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			graph[x][y] = z;
		}
		
		for (int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[1] = 0;
		for (int i = 1; i <= n; i++) {
			int min = -1;
			for (int j = 1; j <= n; j++) {
				if (visited[j]) {
					continue;
				}
				
				if (min == -1 || dist[min] > dist[j]) {
					min = j;
				}
			}
			visited[min] = true;
			
			for (int j = 1; j <= n; j++) {
				if (graph[min][j] == 0) {
					continue;
				}
				dist[j] = Math.min(dist[j], dist[min] + graph[min][j]);
			}
		}
		for (int i = 2; i <= n; i++) {
			System.out.println(dist[i]);
		}
		
		
		
		sc.close();

	}

}
