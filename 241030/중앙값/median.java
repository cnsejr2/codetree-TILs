import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int t, m;
    public static int[] arr = new int[MAX_N];
    
    public static void findMedian() {
        // 중앙값(median)을 계속 관리해줍니다.
        // 중앙값보다 작은 숫자들을 max heap으로 관리하며 (maxPq)
        // 중앙값보다 큰 숫자들을 min heap으로 관리하여 (minPq)
        // 새로운 숫자가 추가될 때마다 
        // 그에 따라 median, maxPq, minPq를 업데이트 해주면 됩니다.
        int median = arr[0];
        PriorityQueue<Integer> maxPq = new PriorityQueue<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        System.out.print(median + " ");
    
        for(int i = 1; i < m; i++) {
            // Case 1.
            // 짝수 번째에 새로운 숫자가 주어졌을 경우에는
            // 양쪽 maxPq, minPq에 들어있는 원소의 수가 
            // 정확히 동일할 것이므로
            // 중앙값은 그대로 두고
            // median과 arr[i]값을 비교하여
            // arr[i] < median이라면 maxPq에
            // arr[i] > median이라면 minPq에 넣어줍니다.
            if(i % 2 == 1) {
                if(arr[i] < median)
                    maxPq.add(-arr[i]);
                else
                    minPq.add(arr[i]);
            }
            // Case 2.
            // 홀수 번째에 새로운 숫자가 주어졌을 경우에는
            // maxPq, minPq 중 개수가 1개 더 많은 곳이
            // 어디인지에 따라 다른 전략을 취해줍니다.
            else {
                // Step 1. 
                // 먼저 maxPq, minPq 중 개수가 1개 더 많은 쪽에
                // 있는 곳에서 우선순위가 가장 큰 값을 뽑아줍니다.
                // 이를 newCand라 하겠습니다.
                int newCand;
                if(maxPq.size() > minPq.size())
                    newCand = -maxPq.poll();
                else 
                    newCand = minPq.poll();
    
                // Step 2.
                // 이제 maxPq, minPq에 들어있는 숫자의 개수는 정확히
                // 동일할 것입니다.
                // 여기서 우리가 해야 할 일은
                // median, arr[i], newCand에서
                // 가장 작은 값은 maxPq에
                // 가운데 값은 median에 다시 넣어주고
                // 가장 큰 값은 minPq에 넣어줘야 하는 것입니다.
                // 이를 정렬을 이용하면 편하게 구현이 가능합니다.
                int[] nums = new int[]{median, arr[i], newCand};
                Arrays.sort(nums);
                
                // 순서대로 값을 넣어줍니다.
                maxPq.add(-nums[0]);
                median = nums[1];
                minPq.add(nums[2]);
                
                // 홀수 번째의 경우에는 중앙값을 출력해줍니다.
                System.out.print(median + " ");
            }
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        t = sc.nextInt();
        while(t-- > 0) {
            m = sc.nextInt();
            for(int i = 0; i < m; i++)
                arr[i] = sc.nextInt();

            // 홀수 번째마다 중앙값을 찾는 것을 반복합니다.
            findMedian();
        }
    }
}