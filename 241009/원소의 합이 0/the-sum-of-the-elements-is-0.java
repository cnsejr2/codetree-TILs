import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashMap<Integer, Long> a = new HashMap<>();
		HashMap<Integer, Long> b = new HashMap<>();
		HashMap<Integer, Long> c = new HashMap<>();
		HashMap<Integer, Long> d = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			Long num = sc.nextLong();
			a.put(i, num);
		}
		for (int i = 0; i < n; i++) {
			Long num = sc.nextLong();
			b.put(i, num);
		}
		for (int i = 0; i < n; i++) {
			Long num = sc.nextLong();
			c.put(i, num);
		}
		for (int i = 0; i < n; i++) {
			Long num = sc.nextLong();
			d.put(i, num);
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
						long sum = a.get(i) + b.get(j) + c.get(k) + d.get(l);
						if (sum == 0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
		
		sc.close();

	}

}