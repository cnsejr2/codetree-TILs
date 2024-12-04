import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		HashSet<Long> aSet = new HashSet<>();
		for (int i = 0; i < a; i++) {
			aSet.add(sc.nextLong());
		}
		int cnt = 0;
		for (int i = 0; i < b; i++) {
			Long bNum = sc.nextLong();
			if (aSet.contains(bNum)) {
				a--;
			} else {
				cnt++;
			}
		}
		System.out.println(cnt + a);
		
		
		sc.close();

	}

}
