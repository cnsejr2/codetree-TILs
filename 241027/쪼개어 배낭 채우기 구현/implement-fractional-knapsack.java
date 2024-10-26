import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static class Info implements Comparable<Info> {

		int w, v;
		
		Info(int w, int v) {
			this.w = w;
			this.v = v;
		}
		
		@Override
		public int compareTo(Info info) {
			double x = (double) info.v / info.w - (double) this.v / this.w;
			if (x < 0) { // info 의 가치 / 무게 값이 더 작으면 -1 반환 / 순서유지
				return -1;
			} else if (x == 0) { // 가치 / 무게 값이 동일하면 0 반환
				return 0;
			} else { // info의 가치 / 무게값이 더 크면 1 반환 / 순서 변경
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Info> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			
			list.add(new Info(w, v));
		}
		Collections.sort(list);
		
		double ans = 0;
		for (int i = 0; i < list.size(); i++) {
			int w = list.get(i).w;
			int v = list.get(i).v;
			
			if (m >= w) {
				m -= w;
				ans += v;
			} else {
				ans += (double) m / w * v;
				break;
			}
		}
		System.out.printf("%.3f", ans);
		
		sc.close();
	}

}