import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
			
			
		}
		Arrays.sort(arr, new Comparator<String>() {
            // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String n1 = o1 + o2;
				String n2 = o2 + o1;
				
				return n1.compareTo(n2);
			}
        });
		
		String result = String.join("", arr);
		int answer = 0;
		int count = 0;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '(') {
				count++;
			} else {
				answer += count;
			}
		}
		System.out.println(answer);
		
		
		
		sc.close();
		

	}

}