import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			map.put(num, map.getOrDefault(map.get(num), 0) + 1);
		}
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o2).compareTo(map.get(o1));
			}
			
		});
		
		 for (int i = 0; i < k; i++) {
			 System.out.print(keySet.get(i) + " ");
		 }
		
		sc.close();

	}

}