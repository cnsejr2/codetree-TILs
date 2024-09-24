import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	static int n, m;
	static int[][] graph;
	static boolean[][] visit;
	static Queue<Pair> q = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		push(1, 1);
		bfs();
		
		
		System.out.println(visit[n][n] == true ? 1 : 0);
	}

	private static void push(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		q.add(new Pair(x, y));
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x; int y = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (canGo(nx, ny)) {
					push(nx, ny);
				}
			}
		}
		
	}

	private static boolean canGo(int x, int y) {
		// TODO Auto-generated method stub
		if (x > 0 && x <= n && y > 0 && y <= m) {
			if (!visit[x][y] && graph[x][y] == 1) {
				return true;
			}
		}
		return false;
	}

}