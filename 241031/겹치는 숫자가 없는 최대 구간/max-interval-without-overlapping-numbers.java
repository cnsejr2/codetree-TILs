import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 가능한 구간 중 최대 크기를 구합니다.
        int ans = 0;
        int[] countArray = new int[1000001];
        // 구간을 잡아봅니다.
        int j = 0;
        for(int i = 1; i <= n; i++) {
            // 같은 숫자가 3개가 되기 전까지 계속 진행합니다.
            while(j + 1 <= n && countArray[arr[j + 1]] < 1) {
                countArray[arr[j + 1]]++;
                j++;
            }
            
            // 현재 구간 [i, j]는 
            // i를 시작점으로 하는
            // 가장 긴 구간이므로
            // 구간 크기 중 최댓값을 갱신합니다.
            ans = Math.max(ans, j - i + 1);

            // 다음 구간으로 넘어가기 전에
            // arr[i]에 해당하는 값은 countArray에서 지워줍니다.
            countArray[arr[i]]--;
        }

        // 조건을 만족하는 가장 큰 구간의 크기는
        // [1, 2, 2, 1, 3]로 5가 됩니다.
        System.out.print(ans);
		
		
	}

}