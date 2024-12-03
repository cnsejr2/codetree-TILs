import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashSet<Long> s1 = new HashSet<>();
		for (int i = 0; i < n; i++) {
			s1.add(sc.nextLong());
		}
				
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			Long num = sc.nextLong();
			System.out.println(s1.contains(num) == true ? 1 : 0);
		}
		
		sc.close();

	}

}
