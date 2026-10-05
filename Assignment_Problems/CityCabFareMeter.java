import java.util.Scanner;

abstract class Cab {

    protected double km;

    Cab(double km) {
        this.km = km;
    }

    protected abstract double getRate();

    public double calculateFare() {

        double fare = km * getRate();

        return Math.max(100.0, fare);
    }
}

interface NightService {
    double applyNightFare(double fare);
}

class MiniCab extends Cab {

    MiniCab(double km) {
        super(km);
    }

    protected double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {

    SedanCab(double km) {
        super(km);
    }

    protected double getRate() {
        return 14.0;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {

    SUVCab(double km) {
        super(km);
    }

    protected double getRate() {
        return 18.0;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            String cabType = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (cabType) {

                case "MINI":
                    cab = new MiniCab(km);
                    break;

                case "SEDAN":
                    cab = new SedanCab(km);
                    break;

                case "SUV":
                    cab = new SUVCab(km);
                    break;

                default:
                    continue;
            }

            if (time.equals("NIGHT")
                    && !(cab instanceof NightService)) {

                System.out.printf(
                    "%s: night service not available%n",
                    cabType
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            total += fare;

            System.out.printf(
                "%s: %.2f%n",
                cabType, fare
            );
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}