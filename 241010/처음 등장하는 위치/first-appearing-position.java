import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		TreeMap<Long, Integer> map = new TreeMap<>();

		for (int i = 1; i <= n; i++) {
			Long s = sc.nextLong();
			if (!map.containsKey(s)) {
				map.put(s, i);
			}
		}
		Iterator<Entry<Long, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Long, Integer> entry = it.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
		
		
		
		sc.close();

	}

}