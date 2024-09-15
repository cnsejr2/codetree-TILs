import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, q;
	static int r1, c1, r2, c2;
	static int[][] map;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		board = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = map[i][j];
			}
		}
		
		for (int k = 0; k < q; k++) {
			st = new StringTokenizer(br.readLine());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			
			rotate();
			
			for (int i = r1; i <= r2; i++) {
				for (int j = c1; j <= c2; j++) {
					calNum(i, j);
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					map[i][j] = board[i][j];
				}
			}
			
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	private static void calNum(int x, int y) {
		int sum = map[x][y];
		int cnt = 1;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
				sum += map[nx][ny];
				cnt++;
			}
		}
		board[x][y] = sum / cnt;
	}

	private static void rotate() {
		// TODO Auto-generated method stub
		int right = map[r1][c2];
		int down = map[r2][c2];
		int left = map[r2][c1];
		int up = map[r1][c1];
		
		for (int i = c2; i > c1; i--) {
			map[r1][i] = map[r1][i - 1];
		}
		
		for (int i = r2; i > r1; i--) {
			if (i - 1 > r1) {
				map[i][c2] = map[i - 1][c2];
			} else {
				map[i][c2] = right;
			}
		}
		
		for (int i = c1; i < c2; i++) {
			if (i + 1 < c2) {
				map[r2][i] = map[r2][i + 1];
			} else {
				map[r2][i] = down;
			}
		}
		
		for (int i = r1; i < r2; i++) {
			if (i + 1 < r2) {
				map[i][c1] = map[i + 1][c1];
			} else {
				map[i][c1] = left;
			}
		}
	}

}