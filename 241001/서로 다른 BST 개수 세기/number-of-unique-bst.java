import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += dp[j] * dp[i - j -1];
			}
			dp[i] = sum;
		}	
		System.out.println(dp[n]);
		sc.close();

	}

}