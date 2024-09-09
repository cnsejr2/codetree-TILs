import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] c1 
	= {{{0, -1}, {1, -1}}, {{1, 0}, {1, 1}}, {{0, 1}, {-1, 1}}, {{-1, 0}, {-1, -1}}};
	static int result = Integer.MIN_VALUE;
	static int[][] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check1(i, j);
				check2(i, j);
			}
		}
		
		System.out.println(result);

	}

	private static void check2(int x, int y) {
		// TODO Auto-generated method stub
		if (x + 1 < n && x + 2 < n) {
			int sum = arr[x][y] + arr[x + 1][y] + arr[x + 2][y];
			result = Math.max(result, sum);
		}
		
		if (y + 1 < n && y + 2 < n) {
			int sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2];
			result = Math.max(result, sum);
		}
		
	}

	private static void check1(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			int nx1 = x + c1[i][0][0];
			int ny1 = y + c1[i][0][1];
			
			int nx2 = x + c1[i][1][0];
			int ny2 = y + c1[i][1][1];
			
			if (nx1 >= 0 && nx1 < n && ny1 >= 0 && ny1 < n
			 && nx2 >= 0 && nx2 < n && ny2 >= 0 && ny2 < n) {
				int sum = arr[x][y] + arr[nx1][ny1] + arr[nx2][ny2];
				
				result = Math.max(result, sum);
			}
		}
		
	}

}