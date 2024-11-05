import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;

class BStone implements Comparable<BStone> {
    int b, a;

    public BStone(int b, int a) {
        this.b = b;
        this.a = a;
    }

    @Override
    public int compareTo(BStone bs) {
        return this.b - bs.b;         // b 기준 오름차순으로 정렬합니다.
    }
}

public class Main {
    public static final int MAX_C = 100000;
    
    // 변수 선언
    public static int c, n;
    
    public static int[] redStones = new int[MAX_C];
    public static TreeSet<Integer> redS = new TreeSet<>();
    public static ArrayList<BStone> blackStones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        c = sc.nextInt();
        n = sc.nextInt();
        for(int i = 0; i < c; i++)
            redStones[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            blackStones.add(new BStone(b, a));
        }

        // 빨간 돌을 전부 treeset에 넣어줍니다.
        // 추후 검은색 돌 기준으로
        // Aj보다 같거나 큰 최소 Ti값을 빠르게 찾기 위해
        // treeset을 이용합니다.
        for(int i = 0; i < c; i++)
            redS.add(redStones[i]);

        // b 기준 오름차순 정렬을 진행합니다.
        Collections.sort(blackStones);

        // b가 작은 돌부터 보며
        // a보다 같거나 큰 최소 Ti를 찾습니다.
        // 이 값이 만약 b보다 같거나 작다면
        // 이 돌을 선택하는 것이 최선입니다.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int a = blackStones.get(i).a;
            int b = blackStones.get(i).b;

            // a보다 같거나 큰 값이 있다면
            if(redS.ceiling(a) != null) {
                // 최소 Ti를 선택합니다.
                int ti = redS.ceiling(a);
                // Ti가 b보다 같거나 작다면
                // 매칭을 진행합니다.
                if(ti <= b) {
                    ans++;
                    redS.remove(ti);
                }
            }
        }
        System.out.print(ans);
    }
}