import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][21];

        dp[1][arr[1]] = 1;

        for (int i = 2; i <= n - 1; i++) { 
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j + arr[i] <= 20) {
                        dp[i][j + arr[i]] += dp[i - 1][j];
                        dp[i][j + arr[i]] %= 1000000007;
                    }
                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] += dp[i - 1][j];
                        dp[i][j - arr[i]] %= 1000000007;
                    }
                }
            }
        }

        System.out.println(dp[n - 1][arr[n]]);
        sc.close();
    }
}
