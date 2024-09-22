import java.util.Scanner;

public class Main {
	
	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new int[n + 1];
		System.out.println(check(n) % 10007);

		sc.close();

	}

	private static int check(int num) {
		if (dp[num] != 0) {
			return dp[num];
		}
		if (num == 0) {
			return 0;
		} else if (num <= 2) {
			return 1;
		}
		dp[num] = check(num - 2) + check(num - 3);
		return dp[num];
		
	}

}