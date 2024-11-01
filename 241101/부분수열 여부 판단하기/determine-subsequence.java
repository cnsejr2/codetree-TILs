import java.util.Scanner;

public class Main {
	static int[] A;
	static int[] B;
	static int n, m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		A = new int[n + 1];
		B = new int[m + 1];
		
		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 1; i <= m; i++) {
			B[i] = sc.nextInt();
		}
		
		if(isSubsequence())
            System.out.print("Yes");
        else
            System.out.print("No");
		
		sc.close();

	}

	private static boolean isSubsequence() {
		int i = 1;
        // B의 원소를 기준으로
        // 순서대로 매칭이 가능한지를 확인합니다.
        for(int j = 1; j <= m; j++) {
            // A의 원소가 B의 j번째 원소와
            // 일치해지는 위치를 구해줍니다.
            while(i <= n && A[i] != B[j])
                i++;
            
            // 만약 수열 A에서 일치하는 원소를 찾지 못햇다면
            // 부분수열이 아닙니다.
            if(i == n + 1)
                return false;
            // 일치한다면
            // A 원소의 위치도 한칸 앞으로 이동시켜 줍니다.
            else
                i++;
        }
    
        // 전부 매칭하는게 가능했다면
        // 부분수열입니다.
        return true;
	}

}