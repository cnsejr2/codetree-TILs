import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static class Pair implements Comparable<Pair> {
		int b; int a;
		public Pair(int a, int b) {
			this.b = b;
			this.a = a;
		}
		
		@Override
		public int compareTo(Pair o) {
			if (a == o.a) {
				return b - o.b;
			}
			return a - o.a;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		int[] red = new int[c];
		for (int i = 0; i < c; i++) {
			red[i] = sc.nextInt();
		}
		ArrayList<Pair> black = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			black.add(new Pair(a, b));
		}
		Collections.sort(black);
		Arrays.sort(red);;
		
		int result = 0;
		int cIdx = 0;
		int nIdx = 0;
		
//		for (int i = 0; i < c; i++) {
//			System.out.println(red[i]);
//		}
//		
//		for (int i = 0; i < n; i++) {
//			System.out.println(black.get(i).a + " " + black.get(i).b);
//		}
//		System.out.println(r + " " + curB.a + " " + curB.b);
		while (cIdx < c && nIdx < n) {
			int r = red[cIdx];
			Pair curB = black.get(nIdx);
			
			if (r >= curB.a && r <= curB.b) {
				result++;
				cIdx++; nIdx++;
			} else if (r < curB.a) {
				cIdx++;
			} else {
				nIdx++;
			}
		}
		System.out.println(result);
		sc.close();

	}

}