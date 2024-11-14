import java.util.*;

public class Main {
	
	static class Pair implements Comparable<Pair> {
		int type;
		long loc;
		
		public Pair(int type, long loc) {
			this.type = type;
			this.loc = loc;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.loc - o.loc < 0) {
				return -1;
			} else if (this.loc - o.loc > 0) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<Pair> list = new ArrayList<>();
		
		// 불
		for (int i = 0; i < n; i++) {
			int loc = sc.nextInt();
			list.add(new Pair(0, loc));
		}
		// 소방서
		for (int i = 0; i < m; i++) {
			int loc = sc.nextInt();
			list.add(new Pair(1, loc));
		}
		
		Collections.sort(list);

		int j = 0;
		Long ans = Long.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			while (j < list.size() && list.get(j).type == 0) {
				j++;
			}
			
			ans = Math.max(ans, Math.abs(i - j));
		}
		System.out.println(ans);
		sc.close();

	}

}
