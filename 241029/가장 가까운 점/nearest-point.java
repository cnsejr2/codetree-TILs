import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Pair implements Comparable<Pair> {
		int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair p) {
			int num = (this.x + this.y) - (p.x + p.y);
			if (num == 0) {
				if (this.x == p.x) {
					if (this.y < p.y) { return -1; } else { return 1; }
				} else if (this.x < p.x) {
					return -1;
				} else {
					return 1;
				}
			}
			return num; 
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			pq.add(new Pair(x, y));
		}
		for (int i = 0; i < m; i++) {
			Pair pair = pq.poll();
			pq.add(new Pair(pair.x + 2, pair.y + 2));
			
			
		}
		Pair pair = pq.peek();
		System.out.println(pair.x + " " + pair.y);
		
		sc.close();

	}

}