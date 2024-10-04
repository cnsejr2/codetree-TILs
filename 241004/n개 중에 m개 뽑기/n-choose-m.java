import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		comb(1, 0);
				
		sc.close();

	}

	private static void comb(int lastNum, int depth) {
		// TODO Auto-generated method stub
		if (depth == m) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = lastNum; i <=  n; i++) {
			list.add(i);
			comb(i + 1, depth + 1);
			list.remove(list.size() - 1);
		}
		
	}

}