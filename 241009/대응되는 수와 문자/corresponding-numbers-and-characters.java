import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String str = sc.next();
			
			map.put(str, i);
		}
		
		for (int i = 0; i < m; i++) {
			String str = sc.next();
			
			if (!Character.isDigit(str.charAt(0))) {
				System.out.println(map.get(str));
			} else {
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
		            String key = entry.getKey();
		            Integer value = entry.getValue();
		            
		            if (value == Integer.parseInt(str)) {
		            	System.out.println(key);
		            }
		        }
			}
			
		}
		
		sc.close();
		

	}

}