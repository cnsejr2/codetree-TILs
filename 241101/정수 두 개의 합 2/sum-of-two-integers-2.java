import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		Arrays.sort(arr);
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int sum = arr[i] + arr[j];
				if (sum <= k) {
					cnt++;
				} else {
					break;
				}
			}
		}

        System.out.print(cnt);
		
		sc.close();
		
	}

}