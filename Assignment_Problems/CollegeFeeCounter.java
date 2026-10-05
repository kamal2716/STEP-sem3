import java.util.Scanner;

abstract class Student {

    protected String name;

    protected static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    protected abstract double calculateTuition();

    protected double getTransportFee() {
        return 0.0;
    }

    public double getTotalFee() {
        return calculateTuition() + getTransportFee();
    }
}

interface BusUser {
    double getTransportFee();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    protected double calculateTuition() {
        return 40000.0;
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    protected double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    protected double calculateTuition() {
        return 20000.0;
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {

                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;

                default:
                    continue;
            }

            double fee = student.getTotalFee();

            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}