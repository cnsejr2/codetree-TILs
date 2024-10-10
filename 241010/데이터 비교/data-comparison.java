import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> set1 = new HashSet<>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			set1.add(sc.nextInt());
		}
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			System.out.print(set1.contains(num) == true ? 1 + " " : 0 + " ");
		}
		System.out.println();

			
		sc.close();

	}

}