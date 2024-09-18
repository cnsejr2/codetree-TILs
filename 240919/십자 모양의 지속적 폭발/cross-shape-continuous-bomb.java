import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] dxs = { -1, 0, 1, 0};
	static int[] dys = { 0, -1, 0, 1};
	static int n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken()); 
			bomb(b);
			
			jenga();
			
		}
		
		for (int a = 1; a <= n; a++) {
			for (int c = 1; c <= n; c++) {
				System.out.print(map[a][c] + " ");
			}
			System.out.println();
		}

	}

	private static void jenga() {
		// TODO Auto-generated method stub
		int[][] temp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			int t = n;
			for (int j = n; j > 0; j--) {
				if (map[j][i] > 0) {
					temp[t--][i] = map[j][i];
				}
			}
		}
		map = temp;
		
	}

	private static void bomb(int b) {
		int length = 0;
		int x = -1;
		int y = b;
		for (int i = 1; i <= n; i++) {
			if (map[i][b] > 0) {
				length = map[i][b];
				x = i;
				break;
			}
		}

		if (x == -1) {
			return;
		}
		
		map[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			for (int j = 1; j <= length; j++) {
				if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
					map[nx][ny] = 0;
				}
				nx += dxs[i];
				ny += dys[i];
				
				
			}
		}

		
		return;
	}
}