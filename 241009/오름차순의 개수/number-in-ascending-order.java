import java.util.Scanner;

public class Main {
	
	static int n, cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();

		perm(0, 0);
		
		System.out.println(cnt);
		
		sc.close();

	}
	private static void perm(int start, int depth) {
		// TODO Auto-generated method stub
		if (depth == n) {
			cnt++;
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			perm(i, depth + 1);
		}
		
	}

}