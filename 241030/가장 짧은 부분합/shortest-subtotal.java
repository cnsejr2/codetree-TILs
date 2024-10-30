import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		 // 가능한 구간 중 최소 크기를 구합니다.
        int ans = Integer.MAX_VALUE;

        // 모든 구간을 탐색합니다.
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                // 구간 내 합을 구합니다.
                int sumVal = 0;
                for(int l = i; l <= j; l++)
                    sumVal += arr[l];

                // 구간 내 합이 s 이상라면,
                // 구간 크기 중 최댓값을 갱신합니다.
                if(sumVal >= s)
                    ans = Math.min(ans, j - i + 1);
            }
        }

        System.out.print(ans);
		
		sc.close();

	}

}