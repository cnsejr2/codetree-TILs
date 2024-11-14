import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_NUM = 100000;
    
    // 변수 선언
    public static int[] fires = new int[MAX_NUM + 1];
    public static int[] stations = new int[MAX_NUM + 1];
    public static int n, m;
    
    public static int dist(int i, int j) {
        return Math.abs(fires[i] - stations[j]);
    }
    
    public static int putOutFire() {
        // 화재 위치와 소방서 위치가
        // 가장 멀리 떨어져 있는 곳의 값을 계산해줍니다.
        int maxDist = 0;
    
        int j = 1;
        // 화재 가능성이 있는 위치들을 순서대로 보며
        // 더 가까이에 있는 소방서의 위치를 찾아 옮겨줍니다.
        for(int i = 1; i <= n; i++) {
            // 현재 화재 가능성이 있는 위치에서
            // 현재 소방서의 위치보다
            // 그 다음 소방서의 위치가 더 가깝다면
            // 소방서의 위치를 계속 옮겨줍니다.
            while(j + 1 <= m && dist(i, j) > dist(i, j + 1))
                j++;
            
            // 화재 위치와 소방서 위치를 계산하여
            // 최댓값을 갱신해줍니다.
            maxDist = Math.max(maxDist, dist(i, j));
        }
    
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            fires[i] = sc.nextInt();
        for(int i = 1; i <= m; i++)
            stations[i] = sc.nextInt();

        // 주어진 위치를 정렬해줍니다.
        Arrays.sort(fires, 1, n + 1);
        Arrays.sort(stations, 1, m + 1);

        // 화재 진압에 필요한 최소 시간을 구해줍니다.
        System.out.print(putOutFire());
    }
}