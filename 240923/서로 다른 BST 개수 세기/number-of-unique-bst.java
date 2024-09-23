import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[40];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int j = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[j] + dp[j + 1];
			j += 2;
		}
		System.out.println(dp[n]);
		
		
		sc.close();
		
	}

}