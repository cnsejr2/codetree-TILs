import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        int uniqueCount = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);
            if (countMap.get(arr[right]) == 1) {
                uniqueCount++;
            }

            while (uniqueCount == m) {
                minLength = Math.min(minLength, right - left + 1);
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    uniqueCount--;
                }
                left++;
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? -1 : minLength);

        sc.close();
    }
}