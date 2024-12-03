import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int g = sc.nextInt();
		
		HashSet<Integer> invite = new HashSet<>();
		for (int i = 0; i < g; i++) {
			int k = sc.nextInt();
			int cnt = 1;
			int unNum = -1;
			invite.add(sc.nextInt());
			for (int j = 1; j < k; j++) {
				int in = sc.nextInt();
				if (invite.contains(in)) {
					cnt++;
				} else {
					unNum = in;
				}
			}
			if (cnt == (k - 1)) {
				invite.add(unNum);
			}
		}
		System.out.println(invite.size());
		
		sc.close();

	}

}
