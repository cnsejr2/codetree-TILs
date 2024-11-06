import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static long check(String result) {
		Long answer = 0L;
		Long count = 0L;
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == '(') {
				count++;
			} else {
				answer += count;
			}
		}
		return answer;
	}

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
				Long c1 = check(o1 + o2);
				Long c2 = check(o2 + o1);
				
				if (c1 < c2) { return 1; }
				else if (c1 > c2) { return -1; }
				else { return 0; }
			}
        });
		
		
		System.out.println(check(String.join("", arr)));

		sc.close();

	}

}