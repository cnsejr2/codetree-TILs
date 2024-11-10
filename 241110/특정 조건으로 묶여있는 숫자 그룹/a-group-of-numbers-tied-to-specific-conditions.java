import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Long k = sc.nextLong();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int ans = Integer.MIN_VALUE;
		int j = n - 1;
		int i = 0;
		for (i = 0; i < n; i++) {
			
			while (j != 0 && arr[j] - arr[i] < k) {
				j--;
			}
			if (j <= i) {
				break;
			}
			ans = Math.max(ans, j - i - 1);
		}
		System.out.println(ans);
		
		sc.close();

	}

}