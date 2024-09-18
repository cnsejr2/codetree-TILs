import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int k, n;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		n = sc.nextInt();
		
		choose(0);
		
		sc.close();

	}

	private static void choose(int curNum) {
		// TODO Auto-generated method stub
		if (curNum == n) {
			print();
			return;
		}
		
		for (int i = 1; i <= k; i++) {
			list.add(i);
			choose(curNum + 1);
			list.remove(list.size() - 1);
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

}