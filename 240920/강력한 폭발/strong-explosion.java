import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, bombCnt;
	static int[][] map;
	static int[][] bomb;
	static int[] arr = { 1, 2, 3};

	static int[] oneX = { 2, 1, -1, -2};
	static int[] oneY = { 0, 0, 0, 0};
	
	static int[] twoX = { 1, 0, -1, 0};
	static int[] twoY = { 0, 1, 0, -1};
	
	static int[] threeX = { 1, 1, -1, -1};
	static int[] threeY = { 1, -1, 1, -1};
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		bomb = new int[n* n][2];
		bombCnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					bomb[bombCnt][0] = i;
					bomb[bombCnt][1] = j;
					bombCnt++;
				}
				map[i][j] = -1;
				
			}
		}
		
		dupPerm(0, bombCnt);
		
		System.out.println(max);

	}

	private static void dupPerm(int depth, int r) {
		// TODO Auto-generated method stub
		if (depth == r) {
			checkBomb();
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			updateBomb(depth, i);
			dupPerm(depth + 1, r);
			removeBomb(depth, i);
		}
		
	}

	private static void removeBomb(int depth, int k) {
		// TODO Auto-generated method stub
		int x = bomb[depth][0];
		int y = bomb[depth][1];
		map[x][y] = -1;
		
		int[] newX = new int[4];
		int[] newY = new int[4];
		
		if (k == 1) {
			newX = oneX;
			newY = oneY;
		}
		if (k == 2) {
			newX = twoX;
			newY = twoY;
		}
		if (k == 3) {
			newX = threeX;
			newY = threeY;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + newX[i];
			int ny = y + newY[i];
			if (isRange(nx, ny)) {
				if (map[nx][ny] == depth) {
					map[nx][ny] = -1;
				}
			}
		}
	}

	private static void updateBomb(int depth, int k) {
		// TODO Auto-generated method stub
		int x = bomb[depth][0];
		int y = bomb[depth][1];
		map[x][y] = depth;
		
		int[] newX = new int[4];
		int[] newY = new int[4];
		
		if (k == 1) {
			newX = oneX;
			newY = oneY;
		}
		if (k == 2) {
			newX = twoX;
			newY = twoY;
		}
		if (k == 3) {
			newX = threeX;
			newY = threeY;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + newX[i];
			int ny = y + newY[i];
			if (isRange(nx, ny)) {
				if (map[nx][ny] == -1) {
					map[nx][ny] = depth;
				}
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		// TODO Auto-generated method stub
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			return true;
		}
		return false;
	}

	private static void checkBomb() {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > -1) {
					count++;
				}
			}
		}
		max = Math.max(max, count);
	}

}