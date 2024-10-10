import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
		
			if (s.equals("add")) {
				int n1 = sc.nextInt(); int n2 = sc.nextInt();
				map.put(n1, n2);
			} else if (s.equals("remove")) {
				int n1 = sc.nextInt(); 
				map.remove(n1);
			} else if (s.equals("find")) {
				int n1 = sc.nextInt();
				if (map.containsKey(n1)) {
					System.out.println(map.get(n1));
				} else {
					System.out.println("None");
				}
			} else if (s.equals("print_list")) {
				Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
				
				if (map.isEmpty()) {
					System.out.println("None");
				} else {
					while (it.hasNext()) {
						Entry<Integer, Integer> entry = it.next();
						System.out.print(entry.getValue() + " ");
					}
					System.out.println();
				}
			}
		}
		
		
		sc.close();

	}

}