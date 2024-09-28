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

	static int n, k, m, result = 0;
	static int[][] map;
	static boolean[][] visit;;
	static Queue<Pair> q = new ArrayDeque<>();
	static ArrayList<Pair> start = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			start.add(new Pair(x, y));
			
		}
		
		drawMap(0);
		
		System.out.println(result);

	}

	private static void drawMap(int clear) {
		// TODO Auto-generated method stub
		if (clear == m) {
			result = Math.max(result, countClearStone());
			visit = new boolean[n + 1][n + 1];
			return;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
					drawMap(clear + 1);
					map[i][j] = 1;
				}
			}
		}
		
	}

	private static int countClearStone() {
		
		for (int i = 0; i < start.size(); i++) {
			Pair cur = start.get(i);
			visit[cur.x][cur.y] = true;
			q.add(cur);
			bfs();
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (visit[i][j]) {
					count++;
				}
			}
		}
		return count;
		
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
					if (!visit[nx][ny] && map[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
		}
	}

}