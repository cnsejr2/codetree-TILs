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
			while (e != 0 && Math.abs(arr[i] + arr[e]) > min) {
				e--;
			}
			if (e <= i) {
				break;
			}
			min = Math.abs(arr[i] + arr[e]);
		}
 		
		System.out.println(min);
		
		sc.close();
	}

}