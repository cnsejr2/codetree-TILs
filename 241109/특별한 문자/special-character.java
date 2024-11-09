import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int[] ch = new int[26];
		for (int i = 0; i < str.length(); i++) {
			ch[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (ch[c - 'a'] == 1) {
				System.out.println(c);
				sc.close();
				return;
			}
		}
		System.out.println("None");
		
		sc.close();

	}

}