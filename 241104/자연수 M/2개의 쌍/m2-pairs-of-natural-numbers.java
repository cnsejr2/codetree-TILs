import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();

        // 데이터 입력
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            long y = sc.nextInt();
            for (int j = 0; j < x; j++) {
                list.add(y);
            }
        }

        long min = Long.MAX_VALUE;

        int n = list.size();
        for (int i = 0; i < n; i++) {
            long max = 0;
            for (int j = 0; j < n / 2; j++) {
                long a = list.get((i + j * 2) % n);
                long b = list.get((i + j * 2 + 1) % n);

                max = Math.max(max, a + b);
            }
            min = Math.min(max, min);
        }

        System.out.println(min);
        sc.close();
    }
}