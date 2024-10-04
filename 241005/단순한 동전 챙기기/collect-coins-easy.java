import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int n;
    public static boolean [][] visited;
    public static int [][] dist;
    public static boolean [] used;
    public static ArrayList<Tuple> coins = new ArrayList<>();
    public static ArrayList<Tuple> selected = new ArrayList<>();
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {-1, 1, 0 ,0};
    public static Tuple s;
    public static Tuple e;
    public static int ans = Integer.MAX_VALUE;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < n ; j++){
                int c = str.charAt(j);
                if(c == 'S'){
                    s = new Tuple(j, i, 0);
                }
                else if(c == 'E') {
                    e = new Tuple(j, i, 0);
                }
                else if(c != '.') {
                    coins.add(new Tuple(j, i, c-'0'));
                }
            }
        }

        used = new boolean[coins.size()];
        Collections.sort(coins, (Tuple a, Tuple b) -> { // 코인 숫자 오름차순으로 정렬하자
            return a.num - b.num;
        });

        dfs(0, 0);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
    
    public static void dfs(int depth, int start){
        if(depth >= 3){
            int total=0;
            for(int i = 0 ; i < selected.size() - 1; i++){
                total += getDistance(selected.get(i), selected.get(i+1));
            }
            total += (getDistance(s, selected.get(0)) + getDistance(selected.get(selected.size() - 1), e));

            ans = Math.min(total, ans);

            return;
        }
        // 가능한 모든 조합을 찾자
        for(int i = start ; i < coins.size(); i++){
            if(!used[i]){
                used[i] = true;
                selected.add(coins.get(i));
                dfs(depth + 1, i + 1);
                used[i] = false;
                selected.remove(depth);
            }
        }
    }

    public static int getDistance(Tuple from, Tuple to){
        // from -> to 까지의 최단 거리를 구하자
        dist = new int[n][n];
        visited = new boolean[n][n];

        Queue<Tuple> q = new LinkedList<>();
        q.add(from);
        visited[from.y][from.x] = true;
        // bfs
        while(!q.isEmpty()){
            Tuple now = q.poll();
            if(now.x == to.x && now.y == to.y){
                break;
            }
            for(int dir = 0 ; dir < 4 ; dir ++){
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[ny][nx]) continue;
                dist[ny][nx] = dist[now.y][now.x] + 1;
                q.offer(new Tuple(nx, ny, 0));
                visited[ny][nx] = true;
            }
        }
        return dist[to.y][to.x];
    }

    public static class Tuple {
        int x;
        int y;
        int num;
        public Tuple(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    } 

}