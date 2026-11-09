
import java.util.*;

public class LibraryCatalog {
    public static void main(String[] args) {
        String[][] catalog = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}
        };

        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();

        int low = 0;
        int high = catalog.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = catalog[mid][0].compareTo(target);

            if (result == 0) {
                System.out.println(catalog[mid][1]);
                found = true;
                break;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Not Found");
        }

        sc.close();
    }
}
