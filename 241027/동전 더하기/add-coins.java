import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (k / arr[i] > 0) {
				int tmp = k / arr[i];
				cnt += tmp;
				k -= arr[i] * tmp;
			}
		}
		System.out.println(cnt);
		
		
		sc.close();
	}

}