import java.util.Scanner;

public class Main {

    static final int MAX_N = 100001;
    static final int MAX_B = 1000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] basket = new int[MAX_B];
        int[] prefix_sum = new int[MAX_B];

        int max_coord = 0;
        for (int i = 0; i < n; i++) {
            // 사탕 개수 >> 바구니 좌표
            int candy = sc.nextInt();
            int coord = sc.nextInt();
            basket[coord] += candy;
            max_coord = Math.max(max_coord, coord);
        }

        // prefix_sum 계산
        prefix_sum[0] = basket[0];
        for (int i = 1; i <= max_coord; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + basket[i];
        }

        int max_candy = 0;
        for (int l = 0; l <= max_coord; l++) {
            int r = 2 * k + l;
            // r이 범위를 초과하면 max_coord로 조정
            if (r > max_coord) r = max_coord;

            if (l == 0) max_candy = Math.max(max_candy, prefix_sum[r]);
            else max_candy = Math.max(max_candy, prefix_sum[r] - prefix_sum[l - 1]);
        }

        System.out.println(max_candy);
        sc.close();
    }
}