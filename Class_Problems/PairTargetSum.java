
import java.util.*;

public class PairTargetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();
        boolean found = false;

        for (int num : nums) {
            int complement = target - num;

            if (set.contains(complement)) {
                found = true;
                break;
            }

            set.add(num);
        }

        System.out.println(found);

        sc.close();
    }
}
