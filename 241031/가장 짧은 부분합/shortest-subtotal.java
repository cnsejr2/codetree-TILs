import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int r = 0;
        int ans = 1000000;
        long sum = arr[0];

        for(int i = 0;i<n;i++){

            while(true){
                if(sum >= s) break;
                if(r == n-1) break;
                r++;
                sum += arr[r];
            }

            //System.out.printf("%d %d\n", i,r);

            //System.out.println(ans);
            if(sum < s) continue;
            sum -= arr[i];
            if(r-i+1 <= 0) continue;
            ans = Math.min(ans, r-i+1);

        }
        
        if(ans == 1000000) System.out.println(-1);
        else System.out.println(ans);
        
		
		sc.close();

	}

}