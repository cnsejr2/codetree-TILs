import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, ans;
	static int[][] map;
	static int[][] dir;
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};
	static ArrayList<Pair> list = new ArrayList<>();
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		dir = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				dir[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		back(0, r, c);
		
		System.out.println(ans);

	}

	private static void back(int depth, int x, int y) {
		// TODO Auto-generated method stub
		List<Pair> nList = findNext(x, y);
		
		if (nList.isEmpty()) {
			ans = Math.max(ans, depth);
		}
		
		for (Pair next : nList) {
			back(depth + 1, next.x, next.y);
		}
		
	}

	private static List<Pair> findNext(int x, int y) {
		// TODO Auto-generated method stub
		List<Pair> pList = new ArrayList<>();
		int d = dir[x][y];
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		while (nx > 0 && nx <= n && ny > 0 && ny <= n) {
			if (map[x][y] < map[nx][ny]) {
				pList.add(new Pair(nx, ny));
			}
			nx += dx[d];
			ny += dy[d];
		}
		
		return pList;
		
	}

}