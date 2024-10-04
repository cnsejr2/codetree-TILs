import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	static int answer = Integer.MAX_VALUE;
	static int total;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[2 * n];
		total = 0;
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		comb(0, 0, 0);
		
		System.out.println(answer);
		
		sc.close();
	}

	private static void comb(int s, int cnt, int sum) {
		// TODO Auto-generated method stub
		if (cnt == n) {
			int num = total - sum;
			answer = Math.min(answer, Math.abs(sum - num));
			return;
		}
		
		if (n * 2 == s) {
			return;
		}
		
		comb(s + 1, cnt, sum);
		comb(s + 1, cnt + 1, sum + arr[s]);
		
	}

}