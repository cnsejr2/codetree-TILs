import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dxs = {-1, -1, 1, 1};
	static int[] dys = {1, -1, -1, 1};
	static int n;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
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
				for (int w = 1; w < n; w++) {
					for (int h = 1; h < n; h++) {
						max = Math.max(max, countScore(i, j, w, h));
					}
				}
			}
		}
		System.out.println(max);
	}

	private static int countScore(int x, int y, int w, int h) {
		int[] m = {w, h, w, h};
		int sum = 0;
		
		for (int i = 0; i < 4; i++) {
			int dx = dxs[i];
			int dy = dys[i];
			int length = m[i];
			
			for (int j = 0; j < length; j++) {
				x += dx;
				y += dy;
				
				if (x >= 0 && x < n && y >= 0 && y < n) {
					sum += map[x][y];
				} else {
					return 0;
				}
			}
		}
		return sum;
		
	}

}