import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Long k = sc.nextLong();

		Long[] arr = new Long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		
		int cnt = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Long diff = k - arr[i] - arr[j];
				if (map.containsKey(diff)) {
					if (diff == arr[i]) { cnt--; }
					if (diff == arr[j]) { cnt--; }
					cnt += map.get(diff);
				}
			}
		}
		System.out.println(cnt / 3);
		
		sc.close();
	}

}