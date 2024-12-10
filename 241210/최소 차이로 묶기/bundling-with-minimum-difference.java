import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static final int MAX = 1000000007;
	private static int a, b;
	private static int[][] dp = new int[1234][1234];
	private static int[][] seq = new int[2][1234];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		for (int i = 0; i < a; i++) {
			seq[0][i] = sc.nextInt();
		}
		for (int i = 0; i < b; i++) {
			seq[1][i] = sc.nextInt();
		}
		
		Arrays.sort(seq[0], 0, a);
		Arrays.sort(seq[1], 0, b);
		
		if (b < a) {
			int temp = a;
			a = b;
			b = temp;
			
			int[] tArr = seq[0];
			seq[0] = seq[1];
			seq[1] = tArr;
		}

		System.out.println(findDifference(a - 1, b - 1));
		
		sc.close();
	}

	private static int findDifference(int idxA, int idxB) {
		if (idxA < 0) { return 0; }
		if (idxB < 0) { return MAX; }
		
		if (dp[idxA][idxB] != -1) {
			return dp[idxA][idxB];
		}
		int result = MAX;
		
        result = Math.min(result, Math.abs(seq[0][idxA] - seq[1][idxB]) + findDifference(idxA - 1, idxB - 1));
        
        result = Math.min(result, findDifference(idxA, idxB - 1));

        dp[idxA][idxB] = result;
        return result;
	}


}
