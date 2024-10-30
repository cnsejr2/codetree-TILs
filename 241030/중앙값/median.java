import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        
        for (int testCase = 0; testCase < t; testCase++) {
            int m = Integer.parseInt(br.readLine().trim());
            String[] inputArray = br.readLine().trim().split(" ");
            
            int[] array = new int[m];
            for (int i = 0; i < m; i++) {
                array[i] = Integer.parseInt(inputArray[i]);
            }

            TreeSet<Element> sortedSet = new TreeSet<>();
            sortedSet.add(new Element(array[0], 0));
            System.out.print(array[0] + " ");
            
            for (int i = 1; i < m; i++) {
                sortedSet.add(new Element(array[i], i));

                if (i % 2 == 0) {
                    int medianIndex = (sortedSet.size() / 2);
                    int medianValue = sortedSet.stream().skip(medianIndex).findFirst().get().value;
                    System.out.print(medianValue + " ");
                }
            }
            System.out.println();
        }
    }
    
    static class Element implements Comparable<Element> {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element other) {
            if (this.value == other.value) {
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.value, other.value);
        }
    }
}