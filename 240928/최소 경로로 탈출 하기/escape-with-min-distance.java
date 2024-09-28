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

	static int n, m;
	static int[][] map;
	static int[][] visit;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		visit = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(visit[n][m] == 0 ? -1 : visit[n][m] - 1);

	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int[] dx = { -1, 0, 1, 0};
		int[] dy = { 0, -1, 0, 1};
		
		int step = 0;
		
		q.add(new Pair(1, 1));
		visit[1][1] = 1;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			step++;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
					if (visit[nx][ny] == 0 && map[nx][ny] == 1) {
						visit[nx][ny] = visit[cur.x][cur.y] + 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
			
		}
	}

}