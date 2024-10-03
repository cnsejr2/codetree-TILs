import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] arr = new int[51][51];
	static int[][] dp = new int[51][51];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				fillDp(i, j);
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}

	private static void fillDp(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (arr[x][y] > arr[0][0] && arr[i][j] < arr[x][y]) {
					dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
				}
			}
		}
		
	}

}