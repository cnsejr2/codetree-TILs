import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = 0;
		boolean mis = false;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				if (!mis) {
					mis = true;
					ans++;
				}
			} else {
				mis = false;
			}
		}
		System.out.println(ans);
		
		
		sc.close();

	}

}
