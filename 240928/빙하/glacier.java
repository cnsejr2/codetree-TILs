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
	static int[][] board;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static boolean[][] visit;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while (true) {
			time++;
			visit = new boolean[n + 1][m + 1];
			
			int cnt = bfs(1, 1);
			
			if (cnt != 0) {
				result = cnt;
			} else {
				System.out.println((time - 1) + " " + result);
				break;
			}
			
		}
	}

	private static int bfs(int x, int y) {
		int cnt = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			visit[cur.x][cur.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
					if (!visit[nx][ny]) { 
						if (board[nx][ny] == 0) {
							q.add(new Pair(nx, ny));
							visit[nx][ny] = true;
						} else {
							visit[nx][ny] = true;
							board[nx][ny] = 0;
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}

}