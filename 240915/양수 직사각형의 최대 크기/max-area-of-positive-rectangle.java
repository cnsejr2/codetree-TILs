import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static int max = -1;
	
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
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = i; x < n; x++) {
					for (int y = j; y < m; y++) {
						max = Math.max(max, checkRect(i, j, x, y));
					}
				}
			}
		}
		System.out.print(max);
	
	}

	private static int checkRect(int i, int j, int x, int y) {
		int sum = 0;
		for (int a = i; a <= x; a++) {
			for (int b = j; b <= y; b++) {
				if (map[a][b] < 0) {
					return -1;
				} else {
					sum++;
				}
			}
		}
		return sum;
	}

}