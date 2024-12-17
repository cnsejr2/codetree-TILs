import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] dp = new long[1_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[1] = 1; 
        dp[2] = dp[3] = 2;
        
        for (int i = 4; i <= 100000; i++) {
            for (int k = 1; k <= 3; k++) {
                // i - k * 2 > 0인 경우만 확인
                if (i - k * 2 > 0) {
                    dp[i] += dp[i - k * 2];
                }
                // i - k * 2 == 0일 경우, 대칭이 완성된 케이스로 1 추가
                if (i - k * 2 == 0) {
                    dp[i] += 1;
                }
            }
            dp[i] %= MOD; // MOD로 나눈 나머지 저장
        }

        int n = sc.nextInt();
        System.out.println(dp[n] % MOD);
        sc.close();
    }
}
