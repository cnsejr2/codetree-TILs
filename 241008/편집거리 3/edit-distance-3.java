import java.util.Scanner;

public class Main {

	static int MAX_LEN = 1000;
	static int[][] dp = new int[MAX_LEN + 1][MAX_LEN + 1];
	static String s1, s2;
	static int s1Len, s2Len;
	
	public static void initialize() {
		dp[0][0] = 0;
		
		for (int i = 1; i <= s1Len; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= s2Len; i++) {
			dp[0][i] = i;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		s1 = sc.next(); s2 = sc.next();
		
		s1Len = (int) s1.length(); s2Len = (int) s2.length(); 
		
		s1 = "#" + s1; s2 = "#" + s2;
		
		initialize();
		
		for (int i = 1; i <= s1Len; i++) {
			for (int j = 1; j <= s2Len; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		
		System.out.println(dp[s1Len][s2Len]);
		
		sc.close();

	}

}