import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            int temp = arr[n * 2 - 1];
            for (int j = n * 2 - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    

        for (int i = 0; i < n * 2; i++) {
            if (i % n == 0 && i > 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }


        

        sc.close();
    }
}