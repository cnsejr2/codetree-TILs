import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
            	if (arr[i][j] == arr[i][j + 1]) {
            		cnt++;
            	} else {
            		cnt = 1;
            	}
            }
            if (cnt >= m) {
    			sum++;
    		}
        }
        
        for (int i = 0; i < n; i++) {
        	int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
            	if (arr[j][i] == arr[j + 1][i]) {
            		cnt++;
            	} else {
            		cnt = 1;
            	}
            }
            if (cnt >= m) {
    			sum++;
    		}
        }
        System.out.println(sum);

    }
}