import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		TreeMap<String, Integer> map = new TreeMap<>();
		
		int j = 1;
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			if (!map.containsKey(s)) {
				map.put(s, j++);
			}
		}
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
		
		
		
		sc.close();

	}

}