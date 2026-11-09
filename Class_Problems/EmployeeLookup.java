
import java.util.*;

public class  EmployeeLookup{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, String> lookup = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String department = sc.next();

            lookup.put(id, department);
        }

        String searchId = sc.next();

        System.out.println(
            lookup.getOrDefault(searchId, "Unknown")
        );

        sc.close();
    }
}
