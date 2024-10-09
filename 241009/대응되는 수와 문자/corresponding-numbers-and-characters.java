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
		HashMap<String, String> reverseMap = new HashMap<>(); // 값을 기준으로도 찾을 수 있게 하기 위해 역으로 저장
		
		for (int i = 1; i <= n; i++) {
		    String str = sc.next();
		    map.put(str, String.valueOf(i));
		    reverseMap.put(String.valueOf(i), str);
		}
		
		for (int i = 0; i < m; i++) {
		    String query = sc.next();
		    
		    // 키로 검색
		    if (map.containsKey(query)) {
		        System.out.println(map.get(query));
		    } 
		    // 값으로 검색
		    else if (reverseMap.containsKey(query)) {
		        System.out.println(reverseMap.get(query));
		    }
		}
		
		sc.close();

	}

}