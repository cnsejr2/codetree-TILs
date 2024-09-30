import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[][] visit;
	static int n, k, r1, r2, c1, c2;
	static int result = Integer.MAX_VALUE;
	static Queue<Pair> q;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		dfs(0);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		

	}

	private static void dfs(int depth) {
		
		if (depth == k) {
			countTime();
			if (visit[r2][c2] != 0) {
				result = Math.min(result, visit[r2][c2] - 1);
			}
			visit = new int[n + 1][n + 1];
			return;
		}
		
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
					dfs(depth + 1);
					map[i][j] = 1;
				}
			}
		}
		
	}

	private static void countTime() {
		// TODO Auto-generated method stub
		q = new ArrayDeque<>();
		
		Pair cur = new Pair(r1, c1);
		visit[cur.x][cur.y] = 1;
		q.add(cur);

		bfs();
	}
	
	private static void bfs() {
		// TODO Auto-generated method stub
		
		int[] dx = { -1, 0, 1, 0};
		int[] dy = { 0, -1, 0, 1};
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					if (visit[nx][ny] == 0 && map[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						visit[nx][ny] = visit[cur.x][cur.y] + 1;
						if (nx == r2 && ny == c2) {
							return;
						}
					}
				}
			}
		}
	}

}