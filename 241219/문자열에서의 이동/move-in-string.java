import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static final int max = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int[] ene = new int[n];
		
		Arrays.fill(ene, max);
		// 시작 위치의 에너지는 0
		ene[0] = 0;
		for (int i = 0; i < n; i++) {
			if (ene[i] == max) continue;
			
			char next;
			if(str.charAt(i) == 'a') { next = 'b'; } 
			else if(str.charAt(i) == 'b') { next = 'c'; }
			else { next = 'a'; }
			
			for (int j = i + 1; j < n; j++) {
				if (str.charAt(j) == next) {
					int energy = (j - i) * (j - i);
					ene[j] = Math.min(ene[j], ene[i] + energy);
				}
			}
		}
		
		if (ene[n - 1] == max) {
			System.out.println(-1);
		} else {
			System.out.println(ene[n - 1]);
		}
		
		
		
		
		sc.close();

	}

}
