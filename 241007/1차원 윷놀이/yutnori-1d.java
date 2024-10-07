import java.util.Scanner;

public class Main {
	
	static int n, m, k;
	static int[] jump;
	static int[] arr;
	static int score = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		jump = new int[n];
		for (int i = 0; i < n; i++) {
			jump[i] = sc.nextInt();
		}
		
		arr = new int[n];
		back(0);
		
		System.out.println(score);
		sc.close();

	}

	private static void back(int depth) {
		// TODO Auto-generated method stub
		if (depth == n) {
			calc();
			return;
		}
		
		for (int i = 1; i <= k; i++) {
			arr[depth] = i;
			back(depth + 1);
		}
		
	}

	private static void calc() {
		// TODO Auto-generated method stub
		int s = 0;
		int[] player = new int[k + 1];
		for (int i = 0; i < n; i++) {
			player[arr[i]] += jump[i];
			
		}
		for (int i = 1; i <= k; i++) {
			if (player[i] + 1 >= m) {
				s++;
			}
		}
		
		score = Math.max(s, score);
		
		
	}

}