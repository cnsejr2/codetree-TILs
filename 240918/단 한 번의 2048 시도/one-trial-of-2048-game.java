import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[4][4];
	static int[][] temp = new int[4][4];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		String dir = st.nextToken();
		
		rotate(dir);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	private static void rotate(String dir) {
		// TODO Auto-generated method stub
		if (dir.equals("L")) {
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 0;
				for (int j = 0; j < 4; j++) {
					if (map[i][j] > 0) {
						temp[i][t++] = map[i][j];
					}
				}
			}
			map = temp;
			for (int i = 0; i < 4; i++) {
				int prev = map[i][0];
				for (int j = 1; j < 4; j++) {
					if (prev == map[i][j]) {
						map[i][j - 1] += map[i][j];
						map[i][j] = 0;
						prev = 0;
					} else {
						prev = map[i][j];
					}
				}
			}
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 0;
				for (int j = 0; j < 4; j++) {
					if (map[i][j] > 0) {
						temp[i][t++] = map[i][j];
					}
				}
			}
		} else if (dir.equals("R")) {
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 3;
				for (int j = 3; j >= 0; j--) {
					if (map[i][j] > 0) {
						temp[i][t--] = map[i][j];
					}
				}
			}
			map = temp;
			for (int i = 3; i >= 0; i--) {
				int prev = map[i][3];
				for (int j = 2; j >= 0; j--) {
					if (prev == map[i][j]) {
						map[i][j + 1] += map[i][j];
						map[i][j] = 0;
						prev = 0;
					} else {
						prev = map[i][j];
					}
				}
			}
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 3;
				for (int j = 3; j >= 0; j--) {
					if (map[i][j] > 0) {
						temp[i][t--] = map[i][j];
					}
				}
			}
		} else if (dir.equals("U")) {
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 0;
				for (int j = 0; j < 4; j++) {
					if (map[j][i] > 0) {
						temp[t++][i] = map[j][i];
					}
				}
			}
			map = temp;
			for (int i = 0; i < 4; i++) {
				int prev = map[0][i];
				for (int j = 1; j < 4; j++) {
					if (prev == map[j][i]) {
						map[j - 1][i] += map[j][i];
						map[j][i] = 0;
						prev = 0;
					} else {
						prev = map[j][i];
					}
				}
			}
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 0;
				for (int j = 0; j < 4; j++) {
					if (map[j][i] > 0) {
						temp[t++][i] = map[j][i];
					}
				}
			}
			
		} else if (dir.equals("D")) {
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 3;
				for (int j = 3; j >= 0; j--) {
					if (map[j][i] > 0) {
						temp[t--][i] = map[j][i];
					}
				}
			}
			map = temp;
			for (int i = 0; i < 4; i++) {
				int prev = map[3][i];
				for (int j = 2; j >= 0; j--) {
					if (prev == map[j][i]) {
						map[j + 1][i] += map[j][i];
						map[j][i] = 0;
						prev = 0;
					} else {
						prev = map[j][i];
					}
				}
			}
			temp = new int[4][4];
			for (int i = 0; i < 4; i++) {
				int t = 3;
				for (int j = 3; j >= 0; j--) {
					if (map[j][i] > 0) {
						temp[t--][i] = map[j][i];
					}
				}
			}
		}
		
	}

}