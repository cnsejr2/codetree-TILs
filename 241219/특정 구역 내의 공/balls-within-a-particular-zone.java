import java.util.*;

public class Main {
    private static final int INF = 1 << 30;
    private static int[] x = new int[3010], y = new int[3010], temp = new int[3010];
    private static int xSize, ySize;
    private static char[][] grid = new char[6010][6010];
    private static int groupSize;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    // 좌표 압축을 수행하는 함수
    private static int compress(int[] arr, int size) {
        System.arraycopy(arr, 0, temp, 0, size);
        Arrays.sort(temp, 0, size);
        int newSize = (int) Arrays.stream(temp, 0, size).distinct().count();

        for (int i = 0; i < size; i++) {
            arr[i] = Arrays.binarySearch(temp, 0, newSize, arr[i]) * 2;
        }

        return newSize * 2;
    }

    // 스택으로 DFS 수행
    private static void put(Stack<Integer> stackX, Stack<Integer> stackY, int cx, int cy) {
        if (cx < 0 || cx >= xSize || cy < 0 || cy >= ySize || grid[cx][cy] == 'X') return;
        groupSize += (grid[cx][cy] == 'C') ? 1 : 0;
        grid[cx][cy] = 'X';
        stackX.push(cx);
        stackY.push(cy);
    }

    private static void dfs(int startX, int startY) {
        Stack<Integer> stackX = new Stack<>();
        Stack<Integer> stackY = new Stack<>();
        put(stackX, stackY, startX, startY);

        while (!stackX.isEmpty()) {
            int x = stackX.pop();
            int y = stackY.pop();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                put(stackX, stackY, nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int z = 0;

        x[z] = y[z] = -INF; z++;
        x[z] = y[z] = INF; z++;

        for (int i = 0; i < 2 * n; i++) {
            x[z] = sc.nextInt();
            y[z] = sc.nextInt();
            z++;
        }

        for (int i = 0; i < p; i++) {
            x[z] = sc.nextInt();
            y[z] = sc.nextInt();
            z++;
        }

        xSize = compress(x, z);
        ySize = compress(y, z);
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        for (int i = 0; i < n; i++) {
            int a = i * 2 + 2;
            int b = i * 2 + 3;
            int x1 = x[a], y1 = y[a], x2 = x[b], y2 = y[b];

            if (x1 == x2) {
                if (y1 > y2) {
                    int temp = y1;
                    y1 = y2;
                    y2 = temp;
                }
                while (y1 <= y2) {
                    grid[x1][y1] = 'X';
                    y1++;
                }
            } else {
                if (x1 > x2) {
                    int temp = x1;
                    x1 = x2;
                    x2 = temp;
                }
                while (x1 <= x2) {
                    grid[x1][y1] = 'X';
                    x1++;
                }
            }
        }

        for (int i = 0; i < p; i++) {
            int a = i + 2 * n + 2;
            grid[x[a]][y[a]] = 'C';
        }

        int maxGroupSize = 0;

        for (int i = 0; i < p; i++) {
            int a = i + 2 * n + 2;
            groupSize = 0;
            dfs(x[a], y[a]);
            maxGroupSize = Math.max(maxGroupSize, groupSize);
        }

        System.out.println(maxGroupSize);
    }
}
