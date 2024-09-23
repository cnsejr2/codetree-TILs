import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n + 3];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n + 2; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int j = 4;
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[j] + dp[j + 1];
			j += 2;
		}
		System.out.println(dp[n]);
		
		
		sc.close();
		
	}

}