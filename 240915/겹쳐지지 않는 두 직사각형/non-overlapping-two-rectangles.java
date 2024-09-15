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
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = i; x < n; x++) {
					for (int y = j; y < m; y++) {
						max = Math.max(max, checkNext(i, j, x, y));
					}
				}
			}
		}
		
		System.out.println(max);

	}

	private static int checkNext(int i1, int j1, int x1, int y1) {
		int rect1 = getRectSum(i1, j1, x1, y1);
		int max = Integer.MIN_VALUE;
		
		for (int i2 = 0; i2 < n; i2++) {
			for (int j2 = 0; j2 < m; j2++) {
				for (int x2 = i2; x2 < n; x2++) {
					for (int y2 = j2; y2 < m; y2++) {
						if (chcekOverlapped(i1, j1, x1, y1, i2, y2, x2, y2)) {
							max = Math.max(max, rect1 + getRectSum(i2, y2, x2, y2));
						}
					}
				}
			}
		}
		
		return max;
	}

	private static boolean chcekOverlapped(int i1, int j1, int x1, int y1, int i2, int j2, int x2, int y2) {
		boolean[][] visit = new boolean[n][m];
		for (int i = i1; i <= x1; i++) {
			for (int j = j1; j <= y1; j++) {
				visit[i][j] = true;
			}
		}
		
		for (int i = i2; i <= x2; i++) {
			for (int j = j2; j <= y2; j++) {
				if (visit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static int getRectSum(int i, int j, int x, int y) {
		int sum = 0;
		for (int a = i; a <=  x; a++) {
			for (int b = j; b <= y; b++) {
				sum += map[a][b];
			}
		}
		return sum;
	}


}