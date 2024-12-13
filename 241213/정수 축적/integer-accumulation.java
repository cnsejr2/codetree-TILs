import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int INF = Integer.MIN_VALUE;
	static int totalTask, maxFatigue;
	static int[][] dp;
	static int[] taskValues;
	
	private static int getMaxValue(int idx, int cur) {
		if (idx == totalTask) {
			return cur == 0 ? 0 : INF;
		}
		
		if (dp[idx][cur] != -1) {
			return dp[idx][cur];
		}
		
		int result = INF;
		if (cur > 0) {
			if (idx + cur <= totalTask) {
				result = Math.max(result, getMaxValue(idx + cur, 0));
			}
		} else {
			result = Math.max(result, getMaxValue(idx + 1, 0));
		}
		
		if (cur + 1 <= maxFatigue) {
			result = Math.max(result, getMaxValue(idx + 1, cur + 1) + taskValues[idx]);
		}
		
		dp[idx][cur] = result;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		totalTask = sc.nextInt();
		maxFatigue = sc.nextInt();
		
		taskValues = new int[totalTask];
		for (int i = 0; i < totalTask; i++) {
			taskValues[i] = sc.nextInt();
		}
		
		dp = new int[totalTask + 1][maxFatigue + 2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(getMaxValue(0, 0));
		
		sc.close();

	}

}
