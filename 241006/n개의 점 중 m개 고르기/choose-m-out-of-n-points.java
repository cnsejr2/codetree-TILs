import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m;
	static ArrayList<Point> points = new ArrayList<>();
	static ArrayList<Point> select = new ArrayList<>();
	static int max;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			points.add(new Point(x, y));
		}
		
		comb(0, 0);
		
		System.out.println(answer);
		
		sc.close();

	}


	private static void comb(int cur, int cnt) {
		// TODO Auto-generated method stub
		if (cur == n) {
			if (cnt == m) {
				max = 0;
				getDistance(0, 0);
				answer = Math.min(answer, max);
			}
			return;
		}
		
		select.add(points.get(cur));
		comb(cur + 1, cnt + 1);
		select.remove(select.size() - 1);
		comb(cur + 1, cnt);
		
		
	}


	private static void getDistance(int cur, int cnt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < select.size(); i++) {
			for (int j = i + 1; j < select.size(); j++) {
				Point p1 = select.get(i);
				Point p2 = select.get(j);
				
				int distance = (int) (Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
				max = Math.max(max, distance);
			}
		}
		
		
	}

}