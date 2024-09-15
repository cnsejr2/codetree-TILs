import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static int[][] temp;
	static int r, c, m1, m2, m3, m4, dir;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		temp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m1 = Integer.parseInt(st.nextToken());
		m2 = Integer.parseInt(st.nextToken());
		m3 = Integer.parseInt(st.nextToken());
		m4 = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		rotate();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rotate() {
		// TODO Auto-generated method stub
		int[] dxs, dys, move;
		
		if (dir == 0) {
			dxs = new int[]{-1, -1, 1, 1};
			dys = new int[]{1, -1, -1, 1};
			move = new int[]{m1, m2, m3, m4};
		} else {
			dxs = new int[]{-1, -1, 1, 1};
			dys = new int[]{-1, 1, 1, -1};
			move = new int[]{m2, m1, m4, m3};
		}
		
		for (int k = 0; k < 4; k++) {
			int dx = dxs[k];
			int dy = dys[k];
			int length = move[k];
			
			for (int i = 0; i < length; i++) {
				int nx = r + dx;
				int ny = c + dy;
				temp[nx][ny] = map[r][c];
				r = nx;
				c = ny;
			}
		}
		
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = temp[i][j];
            }
        }
	}

}