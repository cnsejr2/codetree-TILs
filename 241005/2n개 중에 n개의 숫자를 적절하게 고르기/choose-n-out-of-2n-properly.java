import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	static boolean[] visit;
	static ArrayList<Integer> list = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static int total;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[2 * n];
		visit = new boolean[2 * n];
		total = 0;
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		comb(0, 0);
		
		System.out.println(answer);
		
		sc.close();
	}

	private static void comb(int depth, int s) {
		// TODO Auto-generated method stub
		if (depth == n) {
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
					sum += list.get(i);
			}
			int num = total - sum;
			answer = Math.min(answer, Math.abs(num - sum));
			return;
		}
		
		for (int i = s; i < 2 * n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				list.add(arr[i]);
				comb(depth + 1, s + 1);
				list.remove(list.size() - 1);
				visit[i] = false;
			}
		}
		
	}

}