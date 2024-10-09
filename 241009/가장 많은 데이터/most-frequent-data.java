import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<>();
		int max = -1;
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			
			map.put(str, map.getOrDefault(str, 0) + 1);
			max = Math.max(max, map.get(str));
			
		}
		
		System.out.println(max);
 		
		
		sc.close();

	}

}