import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override    
		public int compareTo(Pair pair) {
			return this.y - pair.y;        
		
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Pair(x, y));
		}
		
		Collections.sort(list);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int j = n - 1;
			while (j != 0 && list.get(j).y - list.get(i).y >= d) {
				min = Math.min(min, Math.abs(list.get(j).x - list.get(i).x));
				j--;
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		
		
		sc.close();

	}

}