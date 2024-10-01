import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
	static int[][] map;
	static int[][] visit;
	static int[][] result;
	static Pair r;
	static Queue<Pair> q = new ArrayDeque<>();
	static ArrayList<Pair> start = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
		result = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					start.add(new Pair(i, j));
				}
			}
		}
		
		countBadOrange();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 0) {
					System.out.print(-1 + " ");
				} else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

	private static void countBadOrange() {
		for (int i = 0; i < start.size(); i++) {
			Pair cur = start.get(i);
			q.add(cur);
			visit[cur.x][cur.y] = 1;
			
			bfs(cur.x, cur.y);
			
			result[cur.x][cur.y] = visit[r.x][r.y] - 1;
			q = new ArrayDeque<>();
			visit = new int[n + 1][n + 1];
		}
		
	}

	private static void bfs(int sx, int sy) {
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
					if (visit[nx][ny] == 0) {
						if (map[nx][ny] == 1) {
							visit[nx][ny] = visit[x][y] + 1;
							q.add(new Pair(nx, ny));
						}
						if (map[nx][ny] == 2) {
							r = new Pair(nx, ny);
							visit[nx][ny] = visit[x][y] + 1;
							return;
						}
					}
				}
				
				
			}
		}
		
	}

}