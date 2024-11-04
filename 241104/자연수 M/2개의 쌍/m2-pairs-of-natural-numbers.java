import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		ArrayList<Long> list = new ArrayList<Long>();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			long y = sc.nextInt();
			for (int j = 0; j < x; j++) {
				list.add(y);
			}
		}
		
		ArrayList<Long> all = new ArrayList<Long>();
		all.addAll(list); all.addAll(list);
		long min  = Long.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			long max = 0;
			for (int j = 0; j < list.size(); j += 2) {
				long a = all.get(i + j);
				long b = all.get(i + j + 1);
				
				max = Math.max(max, a + b);
			}
			min = Math.min(max, min);
		}
		System.out.println(min);
		
		
		sc.close();
		

	}

}