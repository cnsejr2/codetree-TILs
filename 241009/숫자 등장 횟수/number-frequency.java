import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int i = 0; i < m; i++) {
			int n1 = sc.nextInt();
			System.out.print(map.get(n1) == null ? 0 : map.get(n1)+ " ");
		}
		
		
		
		sc.close();

	}

}