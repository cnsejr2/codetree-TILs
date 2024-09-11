import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n, m, q, r, num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			
			shift(r, d);
			
			num = r;
			String dir = d;
			while (num - 1 >= 0) {
				if (comp(num, num - 1)) {
					dir = dir.equals("L") ? "R" : "L";
					shift(num - 1, dir);
				} else {
					break;
				}
				num--;
			
			}
			
			num = r;
			dir = d;
			while (num + 1 <= n) {
				if (comp(num, num + 1)) {
					dir = dir.equals("L") ? "R" : "L";
					shift(num + 1, dir);
				} else {
					break;
				}
				
				num++;
			}
		}
		print();

	}
	
	

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}



	private static boolean comp(int num1, int num2) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= m; i++) {
			if (arr[num1][i] == arr[num2][i]) {
				return true;
			}
		}
		return false;
		
	}

	private static void shift(int x, String dir) {
		
		// TODO Auto-generated method stub
		if (dir.equals("L")) {
			int temp = arr[x][m];
			for (int i = m ; i > 1; i--) {
				arr[x][i] = arr[x][i - 1];
			}
			arr[x][1] = temp;
		} else {
			int temp = arr[x][1];
			for (int i = 1; i < m; i++) {
				arr[x][i] = arr[x][i + 1];
			}
			arr[x][m] = temp;
		}
		
		
	}

}