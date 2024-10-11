import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 벡터를 리스트로 변환
        Set<Integer>[] v = new HashSet[n];
        for (int i = 0; i < n; i++) {
            v[i] = new HashSet<>();
            v[i].add(i);
        }

        int[] arr = new int[n];
        int[][] changes = new int[k][2];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            changes[i][0] = a;
            changes[i][1] = b;
        }

        // 3번 반복
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < k; i++) {
                int a = changes[i][0];
                int b = changes[i][1];

                // 자리 바꾸기
                int t = arr[a];
                arr[a] = arr[b];
                arr[b] = t;

                // 거쳐간 자리 번호를 set에 저장 -> 중복 방지
                v[arr[a]].add(a);
                v[arr[b]].add(b);
            }
        }

        // Output
        for (int i = 0; i < n; i++) {
            sb.append(v[i].size()).append('\n');
        }

        // 결과 출력
        System.out.print(sb);
    }
}