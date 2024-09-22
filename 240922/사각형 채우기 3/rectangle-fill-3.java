import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1001];
		
		dp[1] = 2;
		dp[2] = 7;
		dp[3] = 22;
		for (int i = 4; i <= n; i++) {
			dp[i] = ((dp[i - 1] + dp[i - 2]) * 3 + 1) % 1000000007;
		}
		
		System.out.println(dp[n]);
		
		
		sc.close();
	}

}