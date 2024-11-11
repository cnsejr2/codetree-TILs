import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n + 1];
		int[] map = new int[n + 1];
		int[] cnt = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			map[arr[i]]++;
		}
		
		int ans = 0;
		int j = 1;
		for (int i = 1; i <= n; i++) {
			while (j <= n && cnt[arr[j]] < map[arr[j]] - 1) {
				cnt[arr[j]]++;
				j++;
			}
			
			int count = 0;
			for (int k = 1; k <= m; k++) {
				if (cnt[k] > 0 && map[k] - cnt[k] > 0) {
					count++;
				}
			}

			if (count == m) {
				ans = Math.max(ans, j - i);
			}
			
			cnt[arr[i]]--;
		}
		System.out.println(ans == 0 ? -1 : ans);
		
		
		sc.close();

	}

}
