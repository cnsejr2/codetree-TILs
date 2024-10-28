import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] B_cards = new int[N];
        

        for (int i = 0; i < N; i++) {
            B_cards[i] = sc.nextInt();
        }
        
        // 전체 카드 리스트 만들기
        List<Integer> all_cards = new ArrayList<>();
        for (int i = 1; i <= 2 * N; i++) {
            all_cards.add(i);
        }
        
        // A_cards 리스트 만들기 (B_cards에 없는 카드들만 추가)
        Set<Integer> b_set = new HashSet<>();
        for (int b : B_cards) {
            b_set.add(b);
        }
        
        List<Integer> A_cards = new ArrayList<>();
        for (int card : all_cards) {
            if (!b_set.contains(card)) {
                A_cards.add(card);
            }
        }
        
        // A_cards와 B_cards 정렬
        Collections.sort(A_cards);
        Arrays.sort(B_cards);
        
        int ans = 0;
        int j = 0;
        
        // 이길 수 있는 경우의 수 계산
        for (int i = 0; i < N; i++) {
            if (A_cards.get(i) > B_cards[j] && j < N) {
                ans++;
                j++;
            }
        }
        
        System.out.println(ans);
        
        sc.close();
    }
}