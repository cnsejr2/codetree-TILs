import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

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
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
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

                v[arr[a]].add(a);
                v[arr[b]].add(b);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(v[i].size());
        }

        sc.close();
	}

}