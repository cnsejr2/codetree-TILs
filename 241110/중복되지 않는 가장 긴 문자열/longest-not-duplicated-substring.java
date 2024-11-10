import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int[] arr = new int[26];
		int j = 0;
		int n = str.length();
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			while (j < n && arr[str.charAt(j) - 'a'] == 0) {
				arr[str.charAt(j) - 'a']++;
				j++;
			}
			ans = Math.max(ans, j - i);
			arr[str.charAt(i) - 'a'] = 0;
		}
		
		System.out.print(ans);
		sc.close();

	}

}