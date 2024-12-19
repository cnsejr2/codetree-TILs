import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a = sc.next();
		String b = sc.next();
		
		int white = 0;
		int black = 0;
		boolean mis = false;
		for (int i = 0; i < n; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				if (a.charAt(i) == 'W') {
					white++;
				} else {
					black++;
				}
			}
		}
		System.out.println(Math.max(white, black));
		
		
		sc.close();
	}

}
