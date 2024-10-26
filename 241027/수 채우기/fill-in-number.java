import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAX_N = 100001;
    static final int INF = Integer.MAX_VALUE / 2; // 큰 값 설정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF); // dp 배열을 큰 값으로 초기화

        dp[2] = 1;
        dp[5] = 1;

        for (int i = 0; i <= n; i++) {
            if (i >= 2 && dp[i - 2] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5 && dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        if (dp[n] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
        sc.close();
    }
}