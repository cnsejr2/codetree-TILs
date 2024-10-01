import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	static int[][] dp;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				result = Math.max(result, dfs(i, j));
			}
		}
		System.out.println(result);
	}
	private static int dfs(int x, int y) {
		// TODO Auto-generated method stub
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx > 0 && nx <= n && ny > 0 & ny <= n) {
				if (arr[nx][ny] > arr[x][y]) {
					cnt = Math.max(cnt, dfs(nx, ny) + 1);
				}
			}
		}
		
		return dp[x][y] = cnt;
	}

}