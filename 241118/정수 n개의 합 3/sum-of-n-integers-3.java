import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] arr = new int[n + 1][n + 1];
		int[][] sum = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
				sum[i][j] = (
						sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j]
						);
			}
		}
	
		
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i <= n - k; i++) {
			for (int j = 0; j <= n - k; j++) {
				ans = Math.max(ans, 
					sum[i + k][j + k] - sum[i][j + k]
					- sum[i + k][j] + sum[i][j]);	
			}
		}
		System.out.println(ans);
		
		
		
		
		sc.close();

	}

}
