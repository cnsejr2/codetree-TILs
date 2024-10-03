import java.util.Scanner;

public class Main {
	
	static int INT_MAX = Integer.MAX_VALUE;
	static int MAX_R = 100;
	static int MAX_N = 100;
	
	static int n;
	static int[][] num = new int[MAX_N + 1][MAX_N + 1];
	static int[][] dp = new int[MAX_N + 1][MAX_N + 1];
	
	static int ans = INT_MAX;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= MAX_R; i++) {
			int j = solve(i);
			
			if (j == INT_MAX) {
				continue;
			}
			
			ans = Math.min(ans, j - i);
		}
		
		System.out.println(ans);
		
		sc.close();
		
	}

	private static int solve(int lower) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (num[i][j] < lower) {
					num[i][j] = INT_MAX;
				}
			}
		}
		
		init();
		
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), num[i][j]);
			}
		}
		return dp[n][n];
	}

	private static void init() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = INT_MAX;
			}
		}
		
		dp[1][1] = num[1][1];
		
		for (int i = 2; i <=  n; i++) {
			dp[i][1] = Math.max(dp[i - 1][1], num[i][1]);
			dp[1][i] = Math.max(dp[1][i - 1], num[1][i]);
		}
		
	}

}