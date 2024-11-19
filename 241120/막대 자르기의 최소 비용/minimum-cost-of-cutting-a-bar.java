import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			sum -= arr[i];
			ans += (arr[i] * sum);
		}
		System.out.println(ans);
		
		sc.close();

	}

}
