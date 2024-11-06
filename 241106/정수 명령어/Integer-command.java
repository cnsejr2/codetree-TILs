import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			TreeSet<Long> s = new TreeSet<Long>();
			
			for (int j = 0; j < n; j++) {
				String str = sc.next();
				if (str.equals("I")) {
					Long num = sc.nextLong();
					s.add(num);
				} else if (str.equals("D")) {
					Long num = sc.nextLong();
					if (s.size() > 0) {
						if (num == 1) {
							s.remove(s.last());
						} else if (num == -1) {
							s.remove(s.first());
						}
					}
				}
			}
			if (s.size() > 0) {
				System.out.println(s.last() + " " + s.first());
			} else {
				System.out.println("EMPTY");
			}
			
		}
		
		
		
		sc.close();

	}

}