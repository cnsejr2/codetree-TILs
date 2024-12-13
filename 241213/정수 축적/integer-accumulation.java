import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int INF = Integer.MIN_VALUE;
	static int totalTask, maxFatigue;
	static int[][] dp;
	static int[] taskValues;
	
	// idx : 현재 작업의 인덱스
	// cur : 현재 피로도
	private static int getMaxValue(int idx, int cur) {
		// 모든 작업을 다 수행한 경우
		if (idx == totalTask) {
			// 피로도가 0이라면 0을 반환하고, 그렇지 않다면 매우 작은 값을 반환
			return cur == 0 ? 0 : INF;
		}
		// 이미 계산된 값이 있다면 그 값을 반환
		if (dp[idx][cur] != -1) {
			return dp[idx][cur];
		}
		
		int result = INF; // 초기값을 매우 작은 값으로 설정
		if (cur > 0) {  // Option 1: 피로도가 0보다 큰 경우 휴식을 취합니다.
			if (idx + cur <= totalTask) {
				result = Math.max(result, getMaxValue(idx + cur, 0));
			}
		} else {
			// Option 2: 피로도를 증가시키지 않고 다음 작업으로 이동합니다.
			result = Math.max(result, getMaxValue(idx + 1, 0));
		}
		// Option 3: 현재 작업을 수행하고 피로도를 증가시킵니다.
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
