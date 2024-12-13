import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double l = sc.nextInt();
		int[] a = new int[n];
		double[][] arr = new double[n][2];
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = a[i] - 0.5;
			arr[i][1] = a[i] + 0.5;
		}
		double end = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (end < arr[i][1]) {
				end = arr[i][0] + l;
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		sc.close();

	}

}
