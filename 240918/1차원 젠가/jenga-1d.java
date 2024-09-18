import java.util.Scanner;

public class Main {
	static final int MAX_N = 100;
	
	static int n;
	static int[] numbers = new int[MAX_N];
	static int endOfArray;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		
		endOfArray = n;
		
		for (int k = 0; k < 2; k++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			s--; e--;
			
			cutArray(s, e);
		}

		System.out.println(endOfArray);
		for (int i = 0; i < endOfArray; i++) {
			System.out.println(numbers[i]);
		}
		
		sc.close();

	}


	private static void cutArray(int s, int e) {
		// TODO Auto-generated method stub
		int[] tempArr = new int[MAX_N];
		int endOfTempArray = 0;
		
		for (int i = 0; i < endOfArray; i++) {
			if (i < s || i > e) {
				tempArr[endOfTempArray++] = numbers[i];
			}
		}
		
		for (int i = 0; i < endOfTempArray; i++) {
			numbers[i] = tempArr[i];
		}
		endOfArray = endOfTempArray;
		
	}

}