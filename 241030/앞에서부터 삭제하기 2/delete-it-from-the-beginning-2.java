import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
        	arr[i] = sc.nextInt();
        }

        float maxAvg = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(-arr[n - 1]);
        sum += arr[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            pq.add(-arr[i]);
            sum += arr[i];

            int minValue = -pq.peek();
            sum -= minValue;
            maxAvg = Math.max(maxAvg, (float) sum / (pq.size() - 1));

            sum += minValue; 
        }

        
        System.out.printf("%.2f\n", maxAvg);
        sc.close();
    }
}