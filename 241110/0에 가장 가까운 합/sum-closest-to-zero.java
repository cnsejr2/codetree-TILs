import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Long[] arr = new Long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		
		Long min = Long.MAX_VALUE;
		int e = n - 1;
		for (int i = 0; i < n; i++) {
			if (i < e) {
				min = Math.min(min, Math.abs(arr[i] + arr[e]));
			}
			while (e - i > i && arr[i] + arr[e] > 0) {
				e--;
				min = Math.min(min, Math.abs(arr[i] + arr[e]));
			}
		}
 		
		System.out.println(min);
		
		sc.close();
	}

}