import java.util.Scanner;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[] visit;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		dfs(1);
		
		System.out.println(cnt - 1);
		
		sc.close();

	}

	private static void dfs(int v) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			if (map[v][i] == 1 && !visit[i]) {
				visit[i] = true;
				cnt++;
				dfs(i);
			}
		}
		
	}

}