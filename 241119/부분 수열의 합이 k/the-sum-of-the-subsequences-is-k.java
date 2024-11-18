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
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				int num = sum[j + i - 1] - sum[j - 1];
				if (num == k) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		sc.close();

	}

}
