import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		TreeSet<Long> s = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (str.equals("add")) {
				Long num = sc.nextLong();
				s.add(num);
			} else if (str.equals("remove")) {
				Long num = sc.nextLong();
				s.remove(num);
			} else if (str.equals("find")) {
				Long num = sc.nextLong();
				System.out.println(s.contains(num));
			} else if (str.equals("lower_bound")) {
				Long num = sc.nextLong();
				Long result = s.ceiling(num);
				if (result == null) {
				    System.out.println("None");
				} else {
				    System.out.println(result);
				}
			} else if (str.equals("upper_bound")) {
				Long num = sc.nextLong();
				Long result = s.higher(num);
				if (result == null) {
				    System.out.println("None");
				} else {
				    System.out.println(result);
				}
			} else if (str.equals("largest")) {
				if (s.size() != 0) {
					Long result = s.last();
					if (result == null) {
					    System.out.println("None");
					} else {
					    System.out.println(result);
					}
				} else {
					System.out.println("None");
				}
			} else if (str.equals("smallest")) {
				if (s.size() != 0) {
					Long result = s.first();
					if (result == null) {
					    System.out.println("None");
					} else {
					    System.out.println(result);
					}
				} else {
					System.out.println("None");
				}
			}
		}
		
		
		
		sc.close();

	}

}