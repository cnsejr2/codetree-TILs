import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 개행 처리
        
        List<String> v1 = new ArrayList<>();
        List<String> v2 = new ArrayList<>();

        // Input
        for (int i = 0; i < n; i++) {
            v1.add(sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            v2.add(sc.nextLine());
        }

        StringBuilder s = new StringBuilder("   ");
        int count = 0;
        boolean once = false;

        // 모든 조합을 3중 for문으로 순회
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {

                    // A 그룹의 조합을 HashSet에 저장
                    Set<String> uset = new HashSet<>();
                    once = false;
                    for (int t = 0; t < n; t++) {
                        s.setCharAt(0, v1.get(t).charAt(i));
                        s.setCharAt(1, v1.get(t).charAt(j));
                        s.setCharAt(2, v1.get(t).charAt(k));
                        uset.add(s.toString());
                    }

                    // HashSet에 저장된 조합들과 B 그룹의 조합을 비교
                    for (int t = 0; t < n; t++) {
                        s.setCharAt(0, v2.get(t).charAt(i));
                        s.setCharAt(1, v2.get(t).charAt(j));
                        s.setCharAt(2, v2.get(t).charAt(k));
                        if (uset.contains(s.toString())) {
                            once = true;
                            break;
                        }
                    }

                    if (!once) count++;
                }
            }
        }

        // Output
        System.out.println(count);
    }
}