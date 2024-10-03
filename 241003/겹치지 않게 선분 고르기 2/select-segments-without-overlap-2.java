import java.util.Scanner;

public class Main {

    static int[][] line;
    static int n;
    static int cnt;

    public static void isDuplicated(int k) {
        int s1 = line[k][0];
        int e1 = line[k][1];

        for (int i = 0; i < n; i++) {
            if (i == k) {
                continue;
            }

            int s2 = line[i][0];
            int e2 = line[i][1];

            boolean flag = false;
            if (s2 <= s1) {
            	if (e2 >= e1) {
            		flag = true;
            	}
            } else {
            	if (e2 <= e2) {
            		flag =  true;
            	}
            }
            if (!flag) {
            	cnt++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        line = new int[n][2];

        for (int i = 0; i < n; i++) {
        	line[i][0] = sc.nextInt();
        	line[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
        	cnt = 1;
            isDuplicated(i);
  
        }

        System.out.println(cnt);

        sc.close();
    }
}