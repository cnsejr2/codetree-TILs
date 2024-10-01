import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static int MAX = 1000000;
    public static int n; //숫자

    public static int[] result = new int[MAX + 1];
    public static boolean[] visit = new boolean[MAX + 1];
    public static Queue<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        visit[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] op = { -1, 1, cur, cur * 2};
            
            for (int i = 0; i < 4; i++) {
                int nx = cur + op[i];
                if (nx >= 0 && nx <= MAX) {
                	if (!visit[nx]) {
                		visit[nx] = true;
                		result[nx] = result[cur] + 1;
                    	q.add(nx);
                	}
                }
            }
        }
        
        System.out.println(result[n]);
        
        sc.close();
    }

}