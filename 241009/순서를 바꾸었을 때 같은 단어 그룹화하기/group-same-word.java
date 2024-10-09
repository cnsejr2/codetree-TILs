import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			
			char[] word = str.toCharArray();
			Arrays.sort(word);
			str = new String(word);
			
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

		System.out.println(map.get(keySet.get(0)));
		sc.close();
		
	}

}