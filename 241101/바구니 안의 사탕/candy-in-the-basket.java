import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int len = 1;
		int[] basket = new int[1000001];
		for (int i = 0; i < n; i++) {
			int cnt = sc.nextInt();
			int loc = sc.nextInt();
			
			basket[loc] = cnt;
			len = Math.max(len, loc);
		}
		int max = 0;
		for (int i = 1; i <= len; i++) {
			int j = 1;
			int cnt = basket[i];
			while (j <= k) {
				if (i - j > 0) { cnt += basket[i - j]; }
				if (i + j <= len) { cnt += basket[i + j]; }
				j++;
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
		
		sc.close();

	}

}