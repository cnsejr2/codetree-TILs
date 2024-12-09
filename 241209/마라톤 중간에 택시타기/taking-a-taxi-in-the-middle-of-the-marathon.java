import java.util.Scanner;

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];
    
    public static int ans = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        // L 배열을 채워줍니다.
        // L[i] = 0번부터 i번까지 빠지는 부분 없이
        //        순서대로 방문하기 위해
        //        이동해야 하는 거리의 합
        L[0] = 0;
        for(int i = 1; i < n; i++)
            L[i] = L[i - 1] + Math.abs(x[i] - x[i - 1]) + Math.abs(y[i] - y[i - 1]);
        
        // R 배열을 채워줍니다.
        // R[i] = i번부터 n - 1번까지 빠지는 부분 없이
        //        순서대로 방문하기 위해
        //        이동해야 하는 거리의 합
        R[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--)
            R[i] = R[i + 1] + Math.abs(x[i + 1] - x[i]) + Math.abs(y[i + 1] - y[i]);
        
        // 각 체크포인트 마다
        // 건너 뛰었다고 했을 때,
        // 가능한 거리 합 중 최솟값을 계산합니다.
        for(int i = 1; i < n - 1; i++)
            ans = Math.min(ans, L[i - 1] + R[i + 1] + Math.abs(x[i + 1] - x[i - 1]) + Math.abs(y[i + 1] - y[i - 1]));

        System.out.print(ans);
    }
}