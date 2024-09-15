import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int end = 1;
		int[] arr = new int[n + 1];
		int[] temp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int s1 = sc.nextInt();
		int e1 = sc.nextInt();
		
		for (int i = s1; i <= e1; i++) {
			arr[i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			if (arr[i] > 0) {
				temp[end] = arr[i];
				end++;
			}
		}
		for (int i = 1; i < end; i++) {
			arr[i] = temp[i];
		}
		
		s1 = sc.nextInt();
		e1 = sc.nextInt();
		
		temp = new int[n + 1];
		for (int i = s1; i <= e1; i++) {
			arr[i] = 0;
		}
		n = end;
		end = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] > 0) {
				temp[end] = arr[i];
				end++;
			}
		}
		if (end == 1) {
			System.out.println(0);
			sc.close();
			return;
		}
		System.out.println(end - 1);
		for (int i = 1; i < end; i++) {
			System.out.println(temp[i]);
		}

		sc.close();

	}

}