import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100000;
    
    // 변수 선언
    public static int n, m;
    public static int[] A = new int[MAX_NUM + 1];
    public static int[] B = new int[MAX_NUM + 1];
    public static int[] L = new int[MAX_NUM + 2];
    public static int[] R = new int[MAX_NUM + 2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            A[i] = sc.nextInt();
        for(int j = 1; j <= m; j++)
            B[j] = sc.nextInt();
         
        // L 배열을 채워줍니다.
        // L[i] = 수열 B의 1번부터 i번까지 1 -> i 순서대로
        //        수열 A의 왼쪽부터 순서대로 매칭헀을 때 
        //        마지막으로 매칭되는 수열 A 원소의 위치
        for(int i = 1, j = 1; j <= m; j++) {
            while(i <= n && A[i] != B[j]) i++;
            L[j] = i;
            if(i <= n) i++;
        }
         
        // R 배열을 채워줍니다.
        // R[i] = 수열 B의 n번부터 i번까지 n -> i 순서대로
        //        수열 A의 오른쪽부터 순서대로 매칭헀을 때 
        //        마지막으로 매칭되는 수열 A 원소의 위치
        for(int i = n, j = m; j >= 1; j--) {
            while(i >= 1 && A[i] != B[j]) i--;
            R[j] = i;
            if(i >= 1) i--;
        }

        // 경계 부분 처리를 위해 적절한 값을 넣어줍니다.
        L[0] = 0;
        R[m + 1] = n + 1;
        
        // 수열 B의 j번 원소를 지웠다고 했을 때
        // L[j - 1] < R[j + 1]을 만족한다면
        // 매칭이 가능하다는 것이므로 그 개수를 세줍니다.
        int ans = 0;
        for(int j = 1; j <= m; j++)
            if(L[j - 1] < R[j + 1]) ans++;
        
        System.out.print(ans);
    }
}