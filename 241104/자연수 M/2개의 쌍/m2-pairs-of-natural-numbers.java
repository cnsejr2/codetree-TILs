import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = 0; j < x; j++) {
				list.add(y);
			}
		}
		
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.addAll(list); all.addAll(list);
		int min  = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int max = 0;
			for (int j = 0; j < list.size(); j += 2) {
				int a = all.get(i + j);
				int b = all.get(i + j + 1);
				
				max = Math.max(max, a + b);
			}
			min = Math.min(max, min);
		}
		System.out.println(min);
		
		
		sc.close();
		

	}

}