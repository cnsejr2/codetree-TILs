import java.util.HashMap;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        String[] words = new String[n + 1];
        
        HashMap<String, Integer> StringToNum = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            words[i] = sc.next();
            StringToNum.put(words[i], i);
        }

        while(m-- > 0) {
            String key = sc.next();

            // 입력된 값이 숫자일 때에는 array에 저장한 문자를 출력합니다.
            if('0' <= key.charAt(0) && key.charAt(0) <= '9')
                System.out.println(words[Integer.parseInt(key)]);
            
            // 입력된 값이 문자일 때에는 hashmap에 기록된 대응되는 숫자를 출력합니다.
            else
                System.out.println(StringToNum.get(key));
        }
        
        
        sc.close();
    }
}