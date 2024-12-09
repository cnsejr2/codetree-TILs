import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> { 
    int first, second;
    public Pair(int first, int second) { 
        this.first = first; 
        this.second = second; 
    }
    @Override
    public int compareTo(Pair b) {
        if(first != b.first) return first - b.first;
        return second - b.second;
    }
}

public class Main {
    // 변수 선언
    public static int n, k;
    public static int ans;
    
    public static ArrayList<Pair> segments = new ArrayList<>();
    public static ArrayList<Pair> points = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();
        
        // n개의 선분을 만들어줍니다.
        int curX = 0;
        for(int i = 0; i < n; i++) {
            int dist = sc.nextInt();
            char cDir = sc.next().charAt(0);
            if(cDir == 'L') {
                segments.add(new Pair(curX - dist, curX));
                curX -= dist;
            }
            else {
                segments.add(new Pair(curX, curX + dist));
                curX += dist;
            }
        }
        // 주어진 좌표의 범위가 큰 경우에는
        // 각 선분을 두 지점으로 나눠서
        // +1, -1로 담은 뒤,
        // 정렬해줍니다.
        for(int i = 0; i < n; i++) {
            int x1 = segments.get(i).first;
            int x2 = segments.get(i).second;
            points.add(new Pair(x1, +1)); // 시작점
            points.add(new Pair(x2, -1)); // 끝점
        }

        // 정렬을 진행합니다.
        Collections.sort(points);

        // 각 위치에 적혀있는 숫자들의 합을 구하면
        // 매 순간마다 겹치는 구간의 횟수가 구해집니다.
        // 이 때 k 이상인 경우에 대해 구간의 합을 구하면 됩니다.
        int sumVal = 0;
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).first;
            int v = points.get(i).second;

            // k개 이상 겹치는 구간이라면
            // 해당 구간의 길이를 더해줍니다.
            if(sumVal >= k) {
                int prevX = points.get(i - 1).first;
                ans += x - prevX;
            }

            // 적혀있는 가중치를 전부 더해줍니다.
            sumVal += v;
        }
        
        System.out.print(ans);
    }
}