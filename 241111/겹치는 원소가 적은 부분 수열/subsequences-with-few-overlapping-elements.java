import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] count = new int[26];
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int j = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			while (j < n && count[arr[j]] < k) {
				count[arr[j]]++;
				j++;
			}
			
			ans = Math.max(ans, j - i);
		}
		System.out.println(ans);
		
		
		
		sc.close();

	}

}