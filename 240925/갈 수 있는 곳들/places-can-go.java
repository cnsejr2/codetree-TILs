import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	
	static int n, k;
    static int result = 0;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Pair> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			q.add(new Pair(x, y));
			visit[x][y] = true;
			result++;
		}
		
		bfs();

		System.out.println(result);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					if (!visit[nx][ny] && map[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						visit[nx][ny] = true;
						result++;
					}
				}
			}
			
			
		}
		
	}



}