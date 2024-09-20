import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static boolean[] visit;
	static ArrayList<Integer> list = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		perm(0);
		
		System.out.println(min);
		
		sc.close();
		
		

	}

	private static void perm(int depth) {
		// TODO Auto-generated method stub
		if (depth == n) {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				if (i + 1 == list.get(i)) {
					return;
				}
				sum += map[i + 1][list.get(i)];
			}
			min = Math.min(sum, min);
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				list.add(i);
				perm(depth + 1);
				visit[i] = false;
				list.remove(list.size() - 1);
			}
			
			
		}
	}

}