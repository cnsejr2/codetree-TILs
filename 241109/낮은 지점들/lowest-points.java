import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (map.containsKey(x)) {
				if (y < map.get(x)) {
					sum -= map.get(x);
					sum += y;
					map.put(x, y);
				}
			} else {
				sum += y;
				map.put(x, y);
			}
		}
		System.out.println(sum);
		
		sc.close();

	}

}