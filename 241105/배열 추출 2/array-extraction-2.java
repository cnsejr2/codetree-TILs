import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Pair implements Comparable<Pair> {
	    int num, idx;

	    public Pair(int num, int idx) {
	        this.num = num;
	        this.idx = idx;
	    }

	    @Override
	    public int compareTo(Pair t) {
	    	if (this.num == t.num) {
	    		return this.idx - t.idx;
	    	} else {
	    		return this.num - t.num;
	    	}
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if(!pq.isEmpty()) {
					while (!pq.isEmpty()) {
						Pair cur = pq.poll();
						if (cur.idx == 0) {
							cur.num *= -1;
						}
						System.out.println(cur.num);
					}
					System.out.println(0);
				}
			} else {
				if (num < 0) {
					pq.add(new Pair(num * -1, 0));
				} else {
					pq.add(new Pair(num, 1));
				}	
			}
		}

	
		
		sc.close();

	}

}