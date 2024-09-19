import java.util.*;

public class Main {

    static int n;
    static int cnt = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static void dfs(int depth) {

        if (depth == n) {
            if (check()) {
                cnt++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }


    private static boolean check() {
		for (int i = 0; i < n; i += list.get(i)) {
			if (i + list.get(i) > n) {
				return false;
			}
			
			for (int j = i; j < i + list.get(i);j++) {
				if (list.get(j) != list.get(i)) {
					return false;
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(0);
        System.out.println(cnt);
        
        sc.close();
    }
}