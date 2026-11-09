
import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {

    public static String[] rotateRoster(
            String[] names, long k) {

        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        long k = sc.nextLong();

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
