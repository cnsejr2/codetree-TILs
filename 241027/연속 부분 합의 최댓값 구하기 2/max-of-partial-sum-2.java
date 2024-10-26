import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new  int[n];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = Math.max(sum, 0) + arr[i];
			max = Math.max(sum, max);
		}
		System.out.println(max);
		
		
		sc.close();
		

	}

}