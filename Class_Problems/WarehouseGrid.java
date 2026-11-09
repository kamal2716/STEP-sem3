
import java.util.*;

public class WarehouseGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        int total = 0;
        int max = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Total = " + total);
        System.out.println("MaxCoordinate = (" +
                           maxRow + ", " + maxCol + ")");

        sc.close();
    }
}
