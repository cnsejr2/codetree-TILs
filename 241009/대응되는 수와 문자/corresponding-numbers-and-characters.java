import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, String> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String str = sc.next();
			
			map.put(str, String.valueOf(i));
		}
		
		for (int i = 0; i < m; i++) {
			String str = sc.next();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                
                if (key.equals(str)) {
                    System.out.println(value);
                    break;
                } else if (value.equals(str)) {
                    System.out.println(key);
                    break;
                }
          
            }
        
		}
		
		sc.close();
		

	}

}