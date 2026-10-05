class Locker {
    private String combination;
    private final int lockerNumber;

    Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        if (l.changeCode("1234", "5678")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }

        if (l.changeCode("0000", "9999")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }
    }
}