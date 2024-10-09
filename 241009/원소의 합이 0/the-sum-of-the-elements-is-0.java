import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long[] c = new long[n];
        long[] d = new long[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextLong();
        }
        
        // a[i] + b[j]의 합을 저장할 해시맵
        HashMap<Long, Integer> abSum = new HashMap<>();
        
        // a와 b의 모든 합을 해시맵에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sumAB = a[i] + b[j];
                abSum.put(sumAB, abSum.getOrDefault(sumAB, 0) + 1);
            }
        }
        
        int cnt = 0;
        
        // c와 d의 모든 합의 음수를 해시맵에서 찾음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sumCD = -(c[i] + d[j]);
                if (abSum.containsKey(sumCD)) {
                    cnt += abSum.get(sumCD); // 가능한 경우의 수만큼 더함
                }
            }
        }
        
        System.out.println(cnt);
        sc.close();

	}

}