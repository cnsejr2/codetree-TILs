import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] nums = new String[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLine();
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String newO1 = o1 + o2;
                String newO2 = o2 + o1;
                
                return newO2.compareTo(newO1); // 내림차순 정렬 (newO2가 newO1보다 크면 앞으로)
            }
        });

        // 결과가 "0"으로 시작되면 "0"만 출력
        if (nums[0].equals("0")) {
            System.out.println("0");
        } else {
            StringBuilder result = new StringBuilder();
            for (String num : nums) {
                result.append(num);
            }
            System.out.println(result.toString());
        }
        
        scanner.close();
    }
}