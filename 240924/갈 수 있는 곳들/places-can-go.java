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
	static int result;
	
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
		result = 0;
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bfs(x, y, i);
			
		}

		System.out.println(result);
	}

	private static void bfs(int x, int y, int k) {
		Queue<Pair> q = new LinkedList<>();
		if (visit[x][y] == 0) {
			result++;
		}
		visit[x][y] = k;
		q.add(new Pair(x, y));

		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int cx = cur.x; 
			int cy = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (canGo(nx, ny, k)) {
					if (visit[nx][ny] == 0) {
						result++;
					}
					visit[nx][ny] = k;
					q.add(new Pair(nx, ny));
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

}