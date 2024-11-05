import java.util.Scanner;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int absX, x;

    public Pair(int absX, int x) {
        this.absX = absX;
        this.x = x;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.absX != p.absX)
            return this.absX - p.absX;  // |x| 기준 오름차순 정렬
        else
            return this.x - p.x;        // |x|가 같다면, x 기준 오름차순 정렬
    }
}

public class Main {
    // 변수 선언:
    public static int n;
    
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            // x가 0이 아니라면
            // 우선순위 큐에 넣어줍니다. 
            // (|x|, x) 형태로 넣어줍니다.
            if(x != 0)
                pq.add(new Pair(Math.abs(x), x));
            // x가 0이라면
            // 가장 앞에 있는 원소를 출력해주고 제거합니다.
            else {
                // 우선순위 큐가 비어져 있다면 0을 출력하고 넘어갑니다.
                if(pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll().x);
            }
        }
    }
}