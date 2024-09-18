import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int size, tempSize, n, m;
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

		System.out.println(tempSize);
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				System.out.println(arr[i]);	
			}
		}
		sc.close();

	}

	private static boolean checkArr() {
		
		int[] temp = new int[n];
		int prev = arr[0];
		int cnt = 1;
		int s = 0;
		int e = 0;
		boolean flag = false;
		
		for (int i = 1; i < n; i++) {
			if (prev != arr[i]) {
				if (cnt >= m) {
					for (int j = 0; j < n; j++) {
						if (j >= s && j <= e && arr[j] > 0) {
							arr[j] = 0;
							flag = true;
						}
					}
				}
				cnt = 1;
				s = i;
				prev = arr[i];
			} else {
				cnt++;
				e = i;
			}
		}
		
		if (cnt >= m) {
			for (int j = 0; j < n; j++) {
				if (j >= s && j <= e && arr[j] > 0) {
					arr[j] = 0;
					flag = true;
				}
			}
			
		}
		
		tempSize = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				temp[tempSize++] = arr[i];
			}
		}
		arr = temp;

		return flag;
		
		
	}

}