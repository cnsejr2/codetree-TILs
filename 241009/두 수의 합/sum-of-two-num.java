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
			long diff = k - arr[i];
			if (map.containsKey(diff)) {
				cnt += map.get(diff);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(cnt);
		
		sc.close();
	}

}