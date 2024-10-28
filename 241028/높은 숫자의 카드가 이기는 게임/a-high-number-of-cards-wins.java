import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		boolean[] visit = new boolean[n * 2 + 1];
		int[] arr = new int[n * 2 + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			visit[arr[i]] = true;
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i] + 1; j < n * 2 + 1; j++) {
				if (!visit[j]) {
					visit[j] = true;
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
		
		sc.close();

	}

}