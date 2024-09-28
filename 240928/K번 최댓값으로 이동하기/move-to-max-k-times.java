import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	static int n, k;
	static int[][] map;
	static int[] ans = new int[2];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		ans[0] = Integer.parseInt(st.nextToken());
		ans[1] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < k; i++) {
			bfs();
		}
		
		
		System.out.println(ans[0] + " " + ans[1]);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		int[] dx = { -1, 0, 1, 0};
		int[] dy = { 0, -1, 0, 1};
		
		Queue<Pair> q = new ArrayDeque<>();
		Pair maxNode = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
		boolean[][] visit = new boolean[n + 1][n + 1];
		
		q.add(new Pair(ans[0], ans[1]));
		visit[ans[0]][ans[1]] = true;
		int max = Integer.MIN_VALUE;
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			
			int x = pair.x;
			int y = pair.y;
			
			if (max < map[x][y] && map[ans[0]][ans[1]] > map[x][y]) {
				max = map[x][y];
				maxNode.x = x;
				maxNode.y = y;
			} else if (max == map[x][y]) {
				if (maxNode.x > x) {
                    maxNode.x = x;
                    maxNode.y = y;
                } else if (maxNode.x == x && maxNode.y > y) {
                    maxNode.x = x;
                    maxNode.y = y;
                }
			}
			
			for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n 
        		&& !visit[nx][ny] && map[ans[0]][ans[1]] > map[nx][ny]) {
                    q.add(new Pair(nx, ny));
                    visit[nx][ny] = true;
                }
            }
			
		}
		if (max == Integer.MIN_VALUE) {
			return;
		}
		
		ans[0] = maxNode.x;
		ans[1] = maxNode.y;
		
		
		

	}

}