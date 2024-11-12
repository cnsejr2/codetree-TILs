import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_M = 100000;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] countArrayIn = new int[MAX_M + 1];  // 구간 내 숫자 정보
    public static int[] countArrayOut = new int[MAX_M + 1]; // 구간 외 숫자 정보
    
    public static int distinctNumIn;  // 구간 내 서로 다른 숫자 개수
    public static int distinctNumOut; // 구간 외 서로 다른 숫자 개수
    
    // arr[idx] 숫자를 구간에 집어넣게 되었을 때의
    // countArray와 distinctNum 값을 갱신해줍니다.
    public static void push(int idx) {
        int num = arr[idx];
    
        // 구간 내로 새로 들어온 숫자라면 
        // 숫자 종류가 하나 늘어납니다. 
        if(countArrayIn[num] == 0)
            distinctNumIn++;
        countArrayIn[num]++;
    
        // num과 동일한 구간 외 숫자가
        // 이제 존재하지 않는다면, 숫자 종류를 하나 감소시켜줍니다.
        countArrayOut[num]--;
        if(countArrayOut[num] == 0)
            distinctNumOut--;
    }
    
    // arr[idx] 숫자를 구간에서 빼게 되었을 때의
    // countArray와 distinctNum 값을 갱신해줍니다.
    public static void pop(int idx) {
        int num = arr[idx];
    
        // num과 동일한 구간 내 숫자가 
        // 이제 존재하지 않는다면, 숫자 종류를 하나 감소시켜줍니다.
        countArrayIn[num]--;
        if(countArrayIn[num] == 0)
            distinctNumIn--;
    
        // 구간 외 공간으로 새로 들어온 숫자라면 
        // 숫자 종류가 하나 늘어납니다.
        if(countArrayOut[num] == 0)
            distinctNumOut++; 
        countArrayOut[num]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        // 구간 외 숫자 정보에 대한 초기 값을 계산합니다.
        for(int i = 1; i <= n; i++) {
            // 최초로 적히는 순간이라면
            // 숫자 종류가 하나 늘어납니다.
            if(countArrayOut[arr[i]] == 0)
                distinctNumOut++;
            
            countArrayOut[arr[i]]++;
        }

        // 가능한 구간 중 최소 크기를 구합니다.
        int ans = INT_MAX;
        
        // 구간을 잡아봅니다.
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 구간 내에 1에서 m까지의 숫자가 전부 포함되지 않는한 계속 진행합니다.
            while(j + 1 <= n && distinctNumIn < m) {
                push(j + 1);
                j++;
            }

            // 계속 전진했음에도 결국 1에서 m 숫자를 전부 포함하지 못했다면
            // 탐색을 종료합니다.
            if(distinctNumIn < m)
                break;
            
            // 현재 구간 [i, j]는 
            // i를 시작점으로 하는
            // 가장 짧은 구간이며
            // 만약 구간 외에도 1에서 m 사이의 숫자가 전부 있는 경우라면
            // 구간 크기 중 최솟값을 갱신합니다.
            if(distinctNumOut == m)
                ans = Math.min(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에
            // arr[i]에 해당하는 값을 구간에서 제외해줍니다.
            pop(i);
        }

        // 불가능하다면 -1을 출력합니다.
        if(ans == INT_MAX)
            ans = -1;

        System.out.print(ans);
    }
}