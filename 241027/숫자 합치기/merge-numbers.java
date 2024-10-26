import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.add(sc.nextInt());
        }
        
        int answer = 0;
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            int sum = x + y;
            heap.add(sum);
            answer += sum;
        }
        
        System.out.println(answer);
        sc.close();
    }
}