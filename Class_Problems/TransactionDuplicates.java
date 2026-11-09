
import java.util.*;

public class TransactionDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<String> set = new HashSet<>();

        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            String id = sc.next();

            if (!set.add(id)) {
                duplicate = true;
            }
        }

        System.out.println(duplicate);

        sc.close();
    }
}
