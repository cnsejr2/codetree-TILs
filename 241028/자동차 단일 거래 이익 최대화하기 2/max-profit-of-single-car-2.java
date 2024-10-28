import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] arr = new long[n + 1];
		long[] dp = new long[n + 1];
		dp[0] = Long.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextLong();
			dp[i] = Math.min(dp[i - 1], arr[i]);
		}
		long profit = 0;
		for (int i = n; i > 0; i--) {
			profit = Math.max(profit, arr[i] - dp[i]);
		}
		System.out.println(profit);
		
		sc.close();

	}

}