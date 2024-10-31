import java.util.Scanner;

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int[] arr = new int[MAX_N + 1];
    public static int n, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        s = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        // 가능한 구간 중 가장 짧은 길이를 구합니다.
        int ans = INT_MAX;
        
        // 구간을 잡아봅니다.
        int sumVal = 0;
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 구간 내 합이 s보다 작으면 계속 진행합니다.
            while(j + 1 <= n && sumVal < s) {
                sumVal += arr[j + 1];
                j++;
            }

            // 만약 최대한 이동했는데도
            // sumVal이 s가 되지 못했다면
            // 탐색을 종료합니다.
            if(sumVal < s)
                break;
            
            // 현재 구간 [i, j]는 
            // i를 시작점으로 하는
            // 가장 짧은 구간이므로
            // 구간 크기 중 최솟값을 갱신합니다.
            ans = Math.min(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에
            // arr[i]에 해당하는 값은 구간에서 제외시킵니다.
            sumVal -= arr[i];
        }

        // 만약 불가능하다면
        // -1을 답으로 합니다.
        if(ans == INT_MAX)
            ans = -1;

        System.out.print(ans);
    }
}