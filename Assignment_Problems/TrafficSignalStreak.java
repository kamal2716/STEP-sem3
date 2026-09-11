public class TrafficSignalStreak {

    public static void findLongestStreak(
            String signalLog) {

        if (signalLog.length() == 0) {
            return;
        }

        char longestColor = signalLog.charAt(0);

        int currentStreak = 1;
        int longestStreak = 1;

        for (int i = 1;
             i < signalLog.length();
             i++) {

            if (signalLog.charAt(i) ==
                    signalLog.charAt(i - 1)) {

                currentStreak++;

            } else {

                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {

                longestStreak = currentStreak;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println(
                "Longest Streak: '"
                + longestColor
                + "' repeated "
                + longestStreak
                + " times");
    }

    public static void main(String[] args) {

        findLongestStreak("RRGGGYRR");
    }
}