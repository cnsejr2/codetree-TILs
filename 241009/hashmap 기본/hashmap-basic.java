import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		HashMap<Integer, Integer> m = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (str.equals("add")) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				m.put(n1, n2);
			} else if (str.equals("find")) {
				int n1 = sc.nextInt();
				if (m.containsKey(n1)) {
					System.out.println(m.get(n1));
				} else {
					System.out.println("None");
				}
			} else if (str.equals("remove")) {
				int n1 = sc.nextInt();
				
				m.remove(n1);
			}
			
			
			
			
			
		}
		
		
		sc.close();

	}

}