import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		int ans = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j < n && cnt.getOrDefault(arr[j], 0) < map.get(arr[j]) - 1) {
				cnt.put(arr[j], cnt.getOrDefault(arr[j], 0) + 1);
				j++;
			}
			
			int count = 0;
			for (int k = 1; k <= m; k++) {
				if (cnt.getOrDefault(k, 0) > 0) {
					count++;
				}
			}
//			System.out.println(count);
			if (count == m) {
				ans = Math.max(ans, j - i);
			}
			
			cnt.put(arr[i], cnt.get(arr[i]) - 1);
		}
		System.out.println(ans);
		
		
		sc.close();

	}

}