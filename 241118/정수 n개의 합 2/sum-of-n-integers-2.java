import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n + 1];
		int[] sum = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i - 1] + arr[i];
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n - k; i++) {
			ans = Math.max(ans, sum[i + k] - sum[i]);
		}
		System.out.println(ans);
		sc.close();

	}

}
