import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int x;
		int y;
		int cnt;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	static int n, h, m;
	static int[][] map;;
	static int[][] visit;
	static Queue<Pair> q = new LinkedList<>();
	static ArrayList<Pair> start = new ArrayList<>();
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		result = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start.add(new Pair(i, j));	
				}
			}
		}
		
		countRain();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		

	}

	private static void countRain() {
		// TODO Auto-generated method stub
		for (int i = 0; i < start.size(); i++) {
			visit = new int[n + 1][n + 1];
			Pair pair = start.get(i);
			q = new LinkedList<>();
			q.add(pair);
			visit[pair.x][pair.y] = 1;
			bfs(pair.x, pair.y);
		}

	}

	private static void bfs(int sx, int sy) {
		// TODO Auto-generated method stub
		int[] dx = { -1, 0, 1, 0};
		int[] dy = { 0, -1, 0, 1};

		int cnt = 0;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					if (visit[nx][ny] == 0) {
						if (map[nx][ny] != 1) {
							if (map[nx][ny] < 3) {
								visit[nx][ny] = visit[cur.x][cur.y] + 1;
								q.add(new Pair(nx, ny));
							} else {
								result[sx][sy] = visit[cur.x][cur.y];
								return;
							}
						}
					}
					
				}
				
			}

		}
		result[sx][sy] = -1;
		return;
		
	}

}