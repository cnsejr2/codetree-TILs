import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 1;
		int bomb = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (!visit[i][j]) {
					dfs(i, j, map[i][j]);
					if (result >= 4) {
						bomb++;
					}
					cnt = Math.max(result, cnt);
					result = 1;
				}
			}
		}
		System.out.println(bomb + " " + cnt);

	}

	private static void dfs(int x, int y, int k) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
				if (!visit[nx][ny] && map[nx][ny] == k) {
					dfs(nx, ny, k);
					result++;
				}
			}
		}
	}

}