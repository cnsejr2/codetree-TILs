import java.util.Scanner;

public class Main {
    static int[] arr; 
    static int n;
    static int ans = 0; 

    private static void dfs(int index, int sum) {
        if (index == n - 1) {
            if (sum == arr[n]) {
                ans++;
            }
            return;
        }

        if (sum + arr[index + 1] <= 20) {
            dfs(index + 1, sum + arr[index + 1]);
        }

        if (sum - arr[index + 1] >= 0) {
            dfs(index + 1, sum - arr[index + 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        arr = new int[n + 1]; 

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(1, arr[1]);

        System.out.println(ans);
        sc.close();
    }
}
