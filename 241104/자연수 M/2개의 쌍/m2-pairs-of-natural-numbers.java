import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int y, x;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Pair p) {
        return this.y - p.y;        // y 기준 오름차순으로 정렬합니다.
    }
}

public class Main {    
    // 변수 선언
    public static int n;
    public static ArrayList<Pair> nums = new ArrayList<>();
    
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            nums.add(new Pair(y, x));
        }

        // y 기준으로 오름차순 정렬을 진행합니다.
        Collections.sort(nums);

        // 최선의 전략을 오름차순 정렬 뒤
        // 가장 작은 수와 큰 수를 하나씩 매칭해주는 것입니다.
        int li = 0, ri = n - 1;
        while(li <= ri) {
            int ly = nums.get(li).y;
            int lx = nums.get(li).x;
            int ry = nums.get(ri).y;
            int rx = nums.get(ri).x;

            // 답을 갱신합니다.
            ans = Math.max(ans, ly + ry);

            // 왼쪽 개수가 더 적다면
            // 왼쪽을 전부 매칭시켜줍니다.
            if(lx < rx) {
                // 오른쪽은 lx만큼 개수를 줄여줍니다.
                nums.set(ri, new Pair(ry, rx - lx));

                // 왼쪽 위치를 한칸 뒤로 옮겨줍니다.
                li++;
            }
            // 오른쪽 개수가 더 적다면
            // 오른쪽을 전부 매칭시켜줍니다.
            else if(lx > rx) {
                // 왼쪽은 rx만큼 개수를 줄여줍니다.
                nums.set(li, new Pair(ly, lx - rx));

                // 오른쪽 위치를 한칸 앞으로 옮겨줍니다.
                ri--;
            }
            // 개수가 동일하다면
            // li, ri 위치 모두 옮겨줍니다.
            else {
                li++;
                ri--;
            }
        }
        System.out.print(ans);
    }
}