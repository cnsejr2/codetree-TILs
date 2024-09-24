import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int n;
	static int[][] map;
	static int[][] visit;
	static Queue<Pair> q = new LinkedList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			push(x, y, i);
			bfs(i);
			
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (visit[i][j] > 0) {
					result++;
				}
			}
		}
	

		System.out.println(result);
	}

	private static void bfs(int k) {
		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x; 
			int y = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (canGo(nx, ny, k)) {
					push(nx, ny, k);
				}
			}
		}
		
	}

	private static boolean canGo(int nx, int ny, int k) {
		// TODO Auto-generated method stub
		if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
			if (visit[nx][ny] != k && map[nx][ny] == 0) {
				return true;
			}
		}
		
		return false;
	}

	private static void push(int x, int y, int k) {
		// TODO Auto-generated method stub
		visit[x][y] = k;
		q.add(new Pair(x, y));
		
	}

}