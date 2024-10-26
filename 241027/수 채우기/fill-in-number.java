import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n / 5 + 1];
        for (int i = 0; i < arr.length; i++) {
        	int ans = i;
        	int num = n;
        	num -= (5 * i);
        	ans += (num / 2);
        	if (num % 2 != 0) {
        		arr[i] = Integer.MAX_VALUE;
        	} else {
        		arr[i] = ans;
        	}
        }
        Arrays.sort(arr);

        System.out.println(arr[0] == Integer.MAX_VALUE ? -1 : arr[0]);
        
        sc.close();
    }
}