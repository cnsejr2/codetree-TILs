import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		comb(0, 0);
		
		System.out.println(max);
				
		sc.close();

	}

	private static void comb(int lastNum, int depth) {
		// TODO Auto-generated method stub
		if (depth == m) {
			int result = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				result = result ^ list.get(i);
			}
			max = Math.max(max, result);
			return;
		}
		
		for (int i = lastNum; i < n; i++) {
			list.add(arr[i]);
			comb(i + 1, depth + 1);
			list.remove(list.size() - 1);
		}
		
	}

}