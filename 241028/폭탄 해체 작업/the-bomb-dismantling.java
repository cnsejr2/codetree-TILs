import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < n; i++) {
			int score = sc.nextInt();
			int time = sc.nextInt();
			int sMax = Math.max(score, map.getOrDefault(time, 0));
			map.put(time, sMax);

		}
		int sum = 0;
		for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
			sum += entry.getValue();
		}
		System.out.println(sum);
		
		
		sc.close();

	}

}