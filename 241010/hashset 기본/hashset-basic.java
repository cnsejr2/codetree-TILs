import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			int num = sc.nextInt();
			if (s.equals("add")) {
				set.add(num);
			} else if (s.equals("remove")) {
				set.remove(num);
			} else if (s.equals("find")) {
				System.out.println(set.contains(num));
			}
			
		}
		
		sc.close();

	}

}