import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		PriorityQueue<Integer> box = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			box.add(a * b);
		}
		int cnt = 0;
		while (!box.isEmpty()) {
			if (n > 0) {
				int num = box.poll();
				n -= num;
				cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
