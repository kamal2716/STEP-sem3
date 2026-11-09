
import java.util.Scanner;
import java.util.Arrays;

public class DiceThrowTally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rolls = new int[n];

        int[] count = new int[7];

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
            count[rolls[i]]++;
        }

        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i]);

            if (i < 6) {
                System.out.print(" ");
            }
        }

        System.out.println();

        int index = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                rolls[index] = i;
                index++;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(rolls));

        sc.close();
    }
}
