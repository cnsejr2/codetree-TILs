import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		 int[] dp = new int[n + 1];   
		 Arrays.fill(dp, Integer.MIN_VALUE); 
		 dp[0] = 0;
	 
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == Integer.MIN_VALUE) {
					continue;
				}
				if (j + arr[j] >= i) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
		
		sc.close();
	}

}