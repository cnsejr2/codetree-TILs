import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= 2 * (n - 1); k++) {
					int gold = countGold(i, j, k);
					
					if (gold * m >= digCost(k)) {
						max = Math.max(max, gold);
					}
				}
			}
		}
		System.out.println(max);
	}
	private static int digCost(int k) {
		return k * k + (k + 1) * (k + 1);
	}
	private static int countGold(int x, int y, int k) {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(x - i) + Math.abs(y - j) <= k) {
					cnt += map[i][j];
				}
			}
		}
		return cnt;
	}

}