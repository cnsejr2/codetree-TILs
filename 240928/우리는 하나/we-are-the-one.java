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
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, k, u, d;
	static int[][] board;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static boolean[][] visit;
	static int max = Integer.MIN_VALUE;
	static Queue<Pair> q = new LinkedList<>();
	static ArrayList<Pair> start = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		board = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		drawMap(0);
	
		
		System.out.println(max);
	}

	private static void drawMap(int depth) {
		// TODO Auto-generated method stub
		if (depth == k) {
			max = Math.max(max, countCity());
			visit = new boolean[n + 1][n + 1];
			return;
		}
		
			
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (!visit[i][j]) {
					visit[i][j] = true;
					start.add(new Pair(i, j));
					drawMap(depth + 1);
					visit[i][j] = false;
					start.remove(start.size() - 1);
				}
			}
		}
			
	}

	private static int countCity() {
		// TODO Auto-generated method stub
		for (int i = 0; i < start.size(); i++) {
			Pair cur = start.get(i);
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
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			visit[cur.x][cur.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					if (!visit[nx][ny]) { 
						int diff = Math.abs(board[nx][ny] - board[cur.x][cur.y]);
						if (diff >= u && diff <= d) {
							q.add(new Pair(nx, ny));
							visit[nx][ny] = true;
						}
					}
				}
			}
		}
	}

}