import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] ladder;
	static int[] res;
	static int ans;
	static List<int[]> lines = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ladder = new int[16][n + 1];
		ans = m;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lines.add(new int[] {a, b});
			ladder[b][a] = 1;
			ladder[b][a + 1] = -1;
		}
		
		res = newRes();
		
		go(0, 0);
		
		System.out.println(ans);
		
	}

	private static void go(int depth, int cnt) {
		// TODO Auto-generated method stub
		if (depth == m) {
			int[] tmp = newRes();
			if (sameResWith(tmp)) {
				ans = Math.min(ans, m - cnt);
			}
			return;
		}
		
		int[] line = lines.get(depth);
		int a = line[0];
		int b = line[1];
		ladder[b][a] = 0;
		ladder[b][a + 1] = 0;
		go(depth + 1, cnt + 1);
		ladder[b][a] = 1;
		ladder[b][a + 1] = -1;
		go(depth + 1, cnt);
		
	}

	private static boolean sameResWith(int[] tmp) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= (n / 2) + 1; i++) {
			if (tmp[i] != res[i] || tmp[n - i + 1] != res[n - i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static int[] newRes() {
		int[] res = new int[n + 1];
		int  col, row;
		for (int i = 1; i <= n; i++) {
			col = i;
			row = 15;
			
			while (row > 0) {
				if (ladder[row][col] != 0) {
					col += ladder[row][col];
				}
				row--;
			}
			res[i] = col;
		}
		return res;
	}

}