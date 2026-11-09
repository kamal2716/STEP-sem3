
import java.util.*;

public class 	RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = 0;

        for (int i = 0; i < n; i++) {
            if (k == 0 || nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        System.out.println("Length = " + k);

        System.out.print("nums[0.." + (k - 1) + "] = [");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);

            if (i < k - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}
