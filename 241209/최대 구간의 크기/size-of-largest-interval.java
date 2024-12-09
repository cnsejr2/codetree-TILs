public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
    }
}import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2) { 
        this.x1 = x1; 
        this.x2 = x2; 
    }
}

class Tuple implements Comparable<Tuple> { 
    int x, v, index;
    public Tuple(int x, int v, int index) { 
        this.x = x; 
        this.v = v;
        this.index = index; 
    }
    @Override
    public int compareTo(Tuple b) {
        if(x != b.x) return x - b.x;
        if(v != b.v) return v - b.v;
        return index - b.index;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static Pair[] segments = new Pair[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }   

        // 각 선분을 두 지점으로 나눠 담은 뒤,
        // 정렬해줍니다.
        // 이때 (x좌표, +1-1값, 선분 번호)
        // 형태로 넣어줍니다.
        // +1은 시작점
        // -1은 끝점을 뜻합니다.
        ArrayList<Tuple> points = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int x1 = segments[i].x1;
            int x2 = segments[i].x2;
            points.add(new Tuple(x1, +1, i)); // 시작점
            points.add(new Tuple(x2, -1, i)); // 끝점
        }

        // 정렬을 진행합니다.
        Collections.sort(points);

        // 각 점을 순서대로 순회합니다.
        // 등장하고 아직 사라지지 않은
        // 선분을 hashset으로 관리합니다.
        HashSet<Integer> segs = new HashSet<>();

        int ans = 0; // 가장 큰 구간의 크기를 출력합니다.
        int startX = -1; // 현재 합쳐진 구간의 시작 x값을 기록해줍니다.
        for(int i = 0; i < 2 * n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            // 시작점인 경우입니다.
            if(v == +1) {
                // 남아있는 선분이 없다면
                // 합쳐진 구간의 시작이므로
                // startX값을 갱신해줍니다.
                if((int) segs.size() == 0)
                    startX = x;    
                
                // 해당 선분 번호를 hashset에 넣어줍니다.
                segs.add(index);
            }

            // 끝점인 경우입니다.
            else {
                // 해당 선분을 제거합니다.
                segs.remove(index);

                // 남아있는 선분이 없다면
                // 합쳐진 구간의 끝이므로
                // 답을 갱신해줍니다.
                if((int) segs.size() == 0) {
                    int endX = x;
                    ans = Math.max(ans, endX - startX);
                }
            }
        }
        
        System.out.println(ans);
    }
}