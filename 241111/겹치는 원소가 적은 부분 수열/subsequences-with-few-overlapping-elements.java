import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		HashMap<Long, Integer> map = new HashMap<>();
		Long[] arr = new Long[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		int j = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			while (j < n && map.getOrDefault(arr[j], 0) < k) {
				map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
				j++;
			}

			ans = Math.max(ans, j - i);
			map.put(arr[i], map.get(arr[i]) - 1);
		}
		System.out.println(ans);
		
		
		
		sc.close();

	}

}