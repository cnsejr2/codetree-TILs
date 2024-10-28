import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextLong();
		}
		long profit = 0;
		for (int i = n; i > 0; i--) {
			long cur = arr[i];
			long min = Integer.MAX_VALUE;
			for (int j = i - 1; j > 0; j--) {
				min = Math.min(min, arr[j]);
			}
			
			profit = Math.max(profit, cur - min);
		}
		System.out.println(profit);
		
		sc.close();

	}

}