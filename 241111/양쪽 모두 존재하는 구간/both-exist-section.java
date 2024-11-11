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
		
		int ans = Integer.MAX_VALUE;
		int j = 1;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			while (j <= n && cnt[arr[j]] < map[arr[j]] - 1) {
				if (cnt[arr[j]] == 0) {
					count++;
				}
				cnt[arr[j]]++;
				j++;
			}
			if (count == m) {
				ans = Math.min(ans, j - i);	
			}
			
			cnt[arr[i]]--;
			if (cnt[arr[i]] == 0) {
				count--;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
		
		sc.close();

	}

}
