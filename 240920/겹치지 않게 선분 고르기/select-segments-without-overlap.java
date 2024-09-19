import java.util.Scanner;

public class Main {

	static int n;
	static int[] line;
	static int[][] arr;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int right = -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1][2];
		line = new int[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			line[i] = i;
			right = Math.max(right, arr[i][1]);
		}
		
		for (int i = 1; i <= n; i++) {	
			comb(1, n, i);
		}
		
		System.out.println(max);
		sc.close();
	}
	private static void comb(int start, int n, int r) {
		// TODO Auto-generated method stub
		if (r == 0) {
			checkLine();
			return;
		}
		
		for (int i = start; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, n, r - 1);
				visited[i] = false;
			}
		}
	}
	private static void checkLine() {
		// TODO Auto-generated method stub

		boolean[] selected = new boolean[right + 1];
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				cnt++;
				int s = arr[line[i]][0];
				int e = arr[line[i]][1];
				
				for (int l = s; l <= e; l++) {
					if (!selected[l]) {
						selected[l] = true;
					} else {
						return;
					}
				}
				
			}
		}
		max = Math.max(max, cnt);
	}
	

}