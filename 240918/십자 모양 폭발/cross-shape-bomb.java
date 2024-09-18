import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] dxs = { 1, 0, -1, 0};
	static int[] dys = { 0, 1, 0, -1};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		initRect(r, c);
		
		cutArray();
		
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	private static void cutArray() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			int[] temp = new int[n + 1];
			int tempEnd = n;
			
			for (int j = n; j >= 1; j--) {
				if (map[j][i] > 0) {
					temp[tempEnd--] = map[j][i];
				}
			}

			for (int j = 1; j <= n; j++) {
				map[j][i] = temp[j];
			}
		}
		
	}

	private static void initRect(int r, int c) {
		// TODO Auto-generated method stub
		int length = map[r][c] - 1;
		map[r][c] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nx = r;
			int ny = c;
			
			for (int j = 0; j < length; j++) {
				nx += dxs[i];
				ny += dys[i];
				
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					map[nx][ny] = 0;
				}
			}
		}
	}

}