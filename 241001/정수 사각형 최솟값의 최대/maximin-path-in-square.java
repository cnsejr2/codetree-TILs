import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n + 1][n + 1];
		dp[1][1] = arr[1][1];
		
		for (int i = 2; i <= n; i++) {
			dp[1][i] = Math.min(arr[1][i], dp[1][i - 1]);
			dp[i][1] = Math.min(arr[i][1], dp[i - 1][1]);
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), arr[i][j]);
			}
		}
		
		System.out.println(dp[n][n]);
		
	}

}