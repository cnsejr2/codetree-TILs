import java.util.Scanner;

public class Main {
	
	static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int lenA = a.length();
		int lenB = b.length();
		
		dp = new int[lenA + 1][lenB + 1];
		
		System.out.println(lcs(a, b, lenA, lenB));
		
		sc.close();
	}

	private static int lcs(String a, String b, int lenA, int lenB) {
		if (lenA == 0 || lenB == 0) {
			return 0;
		}
		if (dp[lenA][lenB] != 0) {
			return dp[lenA][lenB];
		}
		if (a.charAt(lenA - 1) == b.charAt(lenB - 1)) {
			dp[lenA][lenB] = 1 + lcs(a, b, lenA - 1, lenB -1);
		} else {
			dp[lenA][lenB] = Math.max(lcs(a, b, lenA, lenB - 1), lcs(a, b, lenA - 1, lenB));
		}
		return dp[lenA][lenB];
		
	}

}