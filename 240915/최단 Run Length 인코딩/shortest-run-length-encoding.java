import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String line = sc.next();
		int len = line.length();
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < len; i++) {
			String str = "";
			str += line.charAt(len - 1);
			str += line.substring(0, len - 1);

			min = Math.min(min, checkStr(str));
			line = str;
		}
		
		System.out.println(min);
		
		sc.close();

	}

	private static int checkStr(String str) {
		
		int length = 2;
		char[] ch = str.toCharArray();
		int cnt = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (ch[i] == ch[i + 1]) {
				cnt++;
			} else {
				length += 2;
				cnt = 1;
			}
		}
		if (cnt == 10) 
			return length + 1;
		return length;

		
	}

}