import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int size, n, m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();			
		}
		
		while (checkArr()) {}
		
		
		
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
		sc.close();

	}

	private static boolean checkArr() {
		
		int[] temp = new int[n];
		int prev = arr[0];
		int cnt = 1;
		int s = 0;
		int e = 0;
		for (int i = 1; i < n; i++) {
			if (prev != arr[i]) {
				if (cnt >= m) {
					size = 0;
					for (int j = 0; j < n; j++) {
						if (j < s || e < j && arr[j] > 0) {
							temp[size++] = arr[j];
						}
					}
					arr = temp;
					return true;
				}
				s = i;
				prev = arr[i];
			} else {
				cnt++;
				e = i;
			}
		}
		return false;
		
		
	}

}