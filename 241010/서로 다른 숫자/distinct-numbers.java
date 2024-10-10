import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (!set.contains(num)) {
				cnt++; 
				set.add(num);
			}
		}
		System.out.println(cnt);
		
		sc.close();

	}

}