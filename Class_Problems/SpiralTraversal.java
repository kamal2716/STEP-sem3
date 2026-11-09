
import java.util.*;

public class SpiralTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
