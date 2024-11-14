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
		
		int ans = Integer.MAX_VALUE;
		int j = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			while (j < n && count < k) {
				if (arr[j] == 1) {
					count++;
				}
				j++;
			}
			
			if (arr[i] == 1 && count == k) {
				ans = Math.min(ans, j - i);
				count--;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
		sc.close();

	}

}
