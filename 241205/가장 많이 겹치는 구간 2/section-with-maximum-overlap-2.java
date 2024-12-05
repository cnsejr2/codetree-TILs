import java.util.*;

public class Main {
	
	static class Point {
        int x;
        int v; // +1 for start, -1 for end
        int index;

        public Point(int x, int v, int index) {
            this.x = x;
            this.v = v;
            this.index = index;
        }
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(x1, 1, i)); // 시작점
            points.add(new Point(x2, -1, i)); // 끝점
        }

        // 시작점 기준 정렬 (시간 먼저, 그다음 상태 우선순위)
        points.sort((e1, e2) -> {
            if (e1.x != e2.x) {
                return Integer.compare(e1.x, e2.x);
            }
            return Integer.compare(e1.v, e2.v);
        });

        int ans = 0; // 최대 구간 개수
        Set<Integer> list = new HashSet<>();

        for (Point p : points) {
            ans = Math.max(ans, list.size()); // 현재 구간 최대 길이 기록
            
            if (p.v == 1) { // 시작점
            	list.add(p.index);
            } else { // 끝점
            	list.remove(p.index);
            }
        }

        System.out.println(ans);
        sc.close();
    }

}
