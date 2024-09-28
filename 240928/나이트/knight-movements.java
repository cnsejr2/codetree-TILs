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

	static int n, r1, c1, r2, c2;
	static int[][] map;
	static int[][] visit;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
		
		bfs();
		
		System.out.println(visit[r2][c2] == 0 ? -1 : visit[r2][c2] - 1);

	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2};
		int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1};
		
		q.add(new Pair(r1, c1));
		visit[r1][c1] = 1;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					if (visit[nx][ny] == 0) {
						visit[nx][ny] = visit[cur.x][cur.y] + 1;
						q.add(new Pair(nx, ny));
					}
				}
			}
			
		}
	}

}