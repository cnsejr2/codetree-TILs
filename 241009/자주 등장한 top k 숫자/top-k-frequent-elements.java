import java.util.ArrayList;
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
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int result = map.get(o2).compareTo(map.get(o1));
				if (result == 0) {
					return o2.compareTo(o1);
				}
				return result;
			}
			
		});
		  
		 for (int i = 0; i < k; i++) {
			 System.out.print(keySet.get(i) + " ");
		 }
		
		sc.close();

	}

}