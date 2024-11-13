import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int k = sc.nextInt();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int j = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n.length(); i++) {
			while (j < n.length() && (map.size() < k || map.containsKey(n.charAt(j)))) {
				char c = n.charAt(j);
				map.put(c, map.getOrDefault(c, 0) + 1);
				j++;
			}
			ans = Math.max(ans, j - i);
			
			map.put(n.charAt(i), map.get(n.charAt(i)) - 1);
			if (map.get(n.charAt(i)) == 0) {
				map.remove(n.charAt(i));
			}
			
		}
		System.out.println(ans);
		
		sc.close();

	}

}
