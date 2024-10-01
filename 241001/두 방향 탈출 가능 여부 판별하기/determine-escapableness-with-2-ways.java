import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1};
	static int[] dy = { 1, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 1);
		
		System.out.println(visit[n][m] == true ? 1 : 0);
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
		
	}

}