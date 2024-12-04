import java.util.*;

public class Main {

	static class Point implements Comparable<Point> {
		Long x; 
		int v, index;
		
		public Point(Long x, int v, int index) {
			this.x = x;
			this.v = v;
			this.index = index;
		}
		
		@Override
		public int compareTo(Point p) {
			return (int) (this.x - p.x);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Long x1 = sc.nextLong();
			Long x2 = sc.nextLong();
			
			points.add(new Point(x1, 1, i));
			points.add(new Point(x2, -1, i));
		}
		Collections.sort(points);
		HashSet<Integer> segs = new HashSet<>();
		int ans = 0; // 서로 다른 구간의 수를 저장합니다.
        for(int i = 0; i < 2 * n; i++) {
            Long x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            // 시작점인 경우입니다.
            if(v == +1) {
                // 남아있는 선분이 없다면
                // 답을 갱신합니다.
                if(segs.size() == 0)
                    ans++;
                
                // 해당 선분 번호를 hashset에 넣어줍니다.
                segs.add(index);
            }

            // 끝점인 경우입니다.
            else {
                // 해당 선분을 제거합니다.
                segs.remove(index);
            }
        }
        
        // 서로 다른 구간의 수 = 2
        System.out.println(ans);
		
		
		sc.close();

	}

}
