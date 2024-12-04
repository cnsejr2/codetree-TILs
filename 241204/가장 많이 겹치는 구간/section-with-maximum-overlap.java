import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] checked = new int[200001];
		int size = 1;
		for (int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			checked[x1] += 1;
			checked[x2] -= 1;
			size = Math.max(size, Math.max(x1, x2));
		}
		
		int sum = 0;
		int max = 0;
		for (int i = 1; i <= size; i++) {
			sum += checked[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
		
		sc.close();
	}

}
