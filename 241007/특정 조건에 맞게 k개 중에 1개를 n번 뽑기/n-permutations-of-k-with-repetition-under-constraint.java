import java.util.Scanner;

public class Main {

	static int k, n;
	static int[] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		n = sc.nextInt();
		
		arr = new int[n];
		
		back(0);
		
		sc.close();

	}

	private static void back(int depth) {
		// TODO Auto-generated method stub
		if (depth == n) {
			if (check()) {
				return;
			}
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= k; i++) {
			arr[depth] = i;
			back(depth + 1);
		}
		
	}

	private static boolean check() {
		if (n < 3) {
			return false;
		}
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
				return true;
			}
		}
		return false;
	}

}