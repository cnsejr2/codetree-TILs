import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Safe {
		int depth;
		int count;
		
		public Safe(int depth, int count) {
			this.depth = depth;
			this.count = count;
		}
	}
	
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 0, 1, 0};
	static int[] dy = { 0, -1, 0, 1};
	static ArrayList<Safe> list = new ArrayList<Safe>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1];
		
		int max = -1;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		for (int d = 1; d <= max; d++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (!visit[i][j] && map[i][j] <= d) {
						countSafe(i, j, d);
					}
				}
			}

			
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (!visit[i][j]) {
						countSafe(i, j, max + 1);
						cnt++;
					}
				}
			}
			
			list.add(new Safe(d, cnt));
			visit = new boolean[n + 1][m + 1];
		}
		
		Collections.sort(list, new Comparator<Safe>() {
            @Override
            public int compare(Safe o1, Safe o2) {
                return o2.count - o1.count;
            }
        });
		
		System.out.println(list.get(0).depth + " " + list.get(0).count);
		

	}

	private static void countSafe(int x, int y, int depth) {
		// TODO Auto-generated method stub
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
				if (!visit[nx][ny] && map[nx][ny] <= depth) {
					countSafe(nx, ny, depth);
				}
			}
		}
	}
}