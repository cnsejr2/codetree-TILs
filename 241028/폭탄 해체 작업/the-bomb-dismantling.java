import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        List<int[]> bombs = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int score = sc.nextInt();
            int limit = sc.nextInt();
            bombs.add(new int[]{score, limit});
        }
        
        // limit 기준, 그 후 score 기준으로 정렬
        bombs.sort((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int MAX_TIME = bombs.get(bombs.size() - 1)[1];
        
        List<List<Integer>> bombList = new ArrayList<>();
        for (int i = 0; i <= MAX_TIME; i++) {
            bombList.add(new ArrayList<>());
        }
        
        for (int[] bomb : bombs) {
            int score = bomb[0];
            int limit = bomb[1];
            bombList.get(limit).add(score);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        
        for (int time = MAX_TIME; time > 0; time--) {
            for (int score : bombList.get(time)) {
                heap.add(score);
            }
            if (!heap.isEmpty()) {
                cnt += heap.poll();
            }
        }
        
        System.out.println(cnt);
        sc.close();
    }
}