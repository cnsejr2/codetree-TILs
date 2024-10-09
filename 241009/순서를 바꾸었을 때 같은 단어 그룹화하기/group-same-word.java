import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    // 변수 선언
    public static int n;
    public static HashMap<String, Integer> wordMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        // 입력 문자열을 정렬한 뒤 map에 저장해줍니다.
        for(int i = 0; i < n; i++){
            String inputStr = sc.next();

            // java는 String 형태에서 정렬할 수 없기 때문에, 배열로 바꾸어 정렬해줍니다.
            char tempArray[] = inputStr.toCharArray();
            Arrays.sort(tempArray);
            inputStr = new String(tempArray);
            
            if(!wordMap.containsKey(inputStr))
                wordMap.put(inputStr, 1);
            else
                wordMap.put(inputStr, wordMap.get(inputStr) + 1);
        }

        // map을 순회하며 최대인 경우를 출력해줍니다.
        int maxVal = 0;
        for(String key : wordMap.keySet()) {
            maxVal = Math.max(maxVal, wordMap.get(key));
        }

        System.out.print(maxVal);
    }
}