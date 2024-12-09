import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    
    // target보다 큰 최초의 위치를 반환합니다.
    public static int upperBound(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
    
        return minIdx;
    }
    
    // target보다 같거나 큰 최초의 위치를 반환합니다.
    public static int lowerBound(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
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
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // 이진탐색을 진행하기 전에
        // 정렬을 진행해줍니다.
        Arrays.sort(arr, 0, n);

        // m개의 질의에 대한 답을 계산합니다.
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 이진탐색을 진행합니다.
            // b보다 큰 최초의 숫자 위치에서
            // a보다 같거나 큰 최초의 숫자 위치를 빼면
            // 문제에서 원하는 답이 됩니다.
            int count = upperBound(b) - lowerBound(a);
            System.out.println(count);
        }
    }
}