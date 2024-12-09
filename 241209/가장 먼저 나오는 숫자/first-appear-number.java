import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];
    
    // target보다 같거나 큰 최초의 위치를 반환합니다.
    public static int lowerBound(int target) {
        int left = 1, right = n;
        int minIdx = n + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
    
        return minIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 1; i <= m; i++) {
            int querry = sc.nextInt();
            
            // 이진탐색을 진행합니다.
            // querry보다 크거나 같은 최소의 값의 위치를 구하고
            // 그 값이 querry와 같으면 위치를,
            // 다르면 -1을 출력합니다.
            int lo = lowerBound(querry);
            if(lo <= n && arr[lo] == querry)
                System.out.println(lo);
            else
                System.out.println(-1);
        }
    }
}