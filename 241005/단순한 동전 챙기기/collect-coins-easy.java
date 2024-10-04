import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	 public static class Coin {
    	int num;
        int x;
        int y;
        public Coin(int num, int x, int y){
        	this.num = num;
            this.x = x;
            this.y = y;
        }
    } 
	
	public static int n;
    public static boolean [][] visited;
    public static int [][] map;
    public static boolean [] used;
    public static ArrayList<Coin> coins = new ArrayList<>();
    public static ArrayList<Coin> selected = new ArrayList<>();
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {-1, 1, 0 ,0};
    public static Coin start;
    public static Coin end;
    public static int answer = Integer.MAX_VALUE;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            String str = br.readLine();
            for(int j = 1 ; j <= n ; j++){
                int c = str.charAt(j - 1);
                if(c == 'S'){
                    start = new Coin(0, i, j);
                }
                else if(c == 'E') {
                    end = new Coin(0, i, j);
                }
                else if(c != '.') {
                    coins.add(new Coin(c - '0', i, j));
                }
            }
        }
        if (coins.size() < 3) {
        	System.out.println(-1);
        	return;
        }
        used = new boolean[coins.size()];
        Collections.sort(coins, (Coin a, Coin b) -> { // 코인 숫자 오름차순으로 정렬하자
            return a.num - b.num;
        });

        dfs(0, 0);
        System.out.println(answer);
    }
    
    public static void dfs(int depth, int s){
        if(depth >= 3){
            int total=0;
            for(int i = 0 ; i < selected.size() - 1; i++){
                total += getDistance(selected.get(i), selected.get(i+1));
            }
            total += (getDistance(start, selected.get(0)) + getDistance(selected.get(selected.size() - 1), end));

            answer = Math.min(total, answer);

            return;
        }
        // 가능한 모든 조합을 찾자
        for(int i = s ; i < coins.size(); i++){
            if(!used[i]){
                used[i] = true;
                selected.add(coins.get(i));
                dfs(depth + 1, i + 1);
                used[i] = false;
                selected.remove(depth);
            }
        }
    }

    public static int getDistance(Coin from, Coin to){
        // from -> to 까지의 최단 거리를 구하자
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        Queue<Coin> q = new LinkedList<>();
        q.add(from);
        visited[from.x][from.y] = true;

        while(!q.isEmpty()){
            Coin now = q.poll();
            if(now.x == to.x && now.y == to.y){
                break;
            }
            for(int dir = 0 ; dir < 4 ; dir ++){
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if(nx > 0 && nx <= n && ny > 0 && ny <= n) {
                	if(!visited[nx][ny]) {
		                map[nx][ny] = map[now.x][now.y] + 1;
		                q.add(new Coin(0, nx, ny));
		                visited[nx][ny] = true;
                	}
                }
            }
        }
        return map[to.x][to.y];
    }


}