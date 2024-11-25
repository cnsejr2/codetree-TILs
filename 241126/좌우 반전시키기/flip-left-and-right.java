import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 100;
    
    public static int n;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 바로 앞에 칸이 아직 0이라면,
        // 현재 칸을 꼭 선택해야 합니다.

        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i - 1] == 0) {
                ans++;
                arr[i - 1] = 1;
                arr[i] ^= 1;
                // 그 다음 칸이 범위 안에 들어오는 경우에만
                // 반전을 진행합니다.
                if(i + 1 < n)
                    arr[i + 1] ^= 1;
            }
        }

        // 불가능에 해당하는 조건은
        // 전부 진행했음에도
        // 마지막 위치에 적혀있는 숫자가
        // 여전히 0인 경우입니다.
        if(arr[n - 1] == 0)
            ans = -1;

        System.out.print(ans);
    }
}