import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

        int ans = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i ++) {
            int price = sc.nextInt();
            ans = Math.max(ans, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        System.out.println(ans);
		
		sc.close();

	}

}