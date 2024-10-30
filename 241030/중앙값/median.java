import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF = (int) 1e9;
        
        int t = Integer.parseInt(br.readLine().trim());
        
        for (int testCase = 0; testCase < t; testCase++) {
            int m = Integer.parseInt(br.readLine().trim());
            String[] inputArray = br.readLine().trim().split(" ");
            
            int[] array = new int[m];
            for (int i = 0; i < m; i++) {
                array[i] = Integer.parseInt(inputArray[i]);
            }

            TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
            sortedMap.put(array[0], 1);
            System.out.print(array[0] + " ");
            
            for (int i = 1; i < m; i++) {
                int current = array[i];
                Map.Entry<Integer, Integer> upper = sortedMap.ceilingEntry(current + 1);
                Map.Entry<Integer, Integer> lower = upper == null ? sortedMap.lastEntry() : sortedMap.lowerEntry(current + 1);
                
                if (lower != null && lower.getKey() == current) {
                    sortedMap.put(current, lower.getValue() + 1);
                } else {
                    sortedMap.put(current, 1);
                }
                
                if (i % 2 == 0) {
                    int middleIndex = (sortedMap.size() / 2);
                    int medianValue = sortedMap.keySet().stream().skip(middleIndex).findFirst().orElse(0);
                    System.out.print(medianValue + " ");
                }
            }
            System.out.println();
        }
    }
}