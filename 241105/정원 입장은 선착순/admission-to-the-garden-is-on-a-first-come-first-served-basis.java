import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, a, b;
    static int maxGap = 0;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    static TreeSet<Pair> oset = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            oset.add(new Pair(a, b));
        }

        int pre = 0;

        Pair pr = oset.pollFirst();
        pq.add(new Pair(pr.second, pr.first));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (pre > p.second) {
                maxGap = Math.max(maxGap, pre - p.second);
                pre += p.first;
            } else {
                pre = p.first + p.second;
            }

            while (!oset.isEmpty()) {
                pr = oset.first();

                if (pq.isEmpty() && pr.first > pre) {
                    pq.add(new Pair(pr.second, pr.first));
                    oset.pollFirst();
                    break;
                }

                if (pr.first <= pre) {
                    pq.add(new Pair(pr.second, pr.first));
                    oset.pollFirst();
                } else {
                    break;
                }
            }
        }

        System.out.println(maxGap);
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.first == o.first) {
                return Integer.compare(this.second, o.second);
            }
            return Integer.compare(this.first, o.first);
        }
    }
}