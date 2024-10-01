import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int[][] dp;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 초기값 설정
        initialize();
       
		for (int i = 2; i <= n; i++) {
			for (int j = n - 1; j > 0; j--) {
				dp[i][j] = Math.min(map[i][j] + dp[i][j + 1] , map[i][j] + dp[i - 1][j]);
			}
		}
		
		System.out.println(dp[n][1]);
		
		sc.close();

	}

	private static void initialize() {
		// TODO Auto-generated method stub
		dp[1][n] = map[1][n];
		
		for (int i = n - 1; i > 0; i--) {
			dp[1][i] = dp[1][i + 1] + map[1][i];
		}
		
		for (int i = 2; i <= n; i++) {
			dp[i][n] = dp[i - 1][n] + map[i][n];
		}
	}

}