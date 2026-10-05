import java.util.Scanner;

abstract class Appliance {

    protected double hours;

    protected static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    protected abstract double getPower();

    public double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }
}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {

    AirConditioner(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 1500.0;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    protected double getPower() {
        return 500.0;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {

                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AirConditioner(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours);
                    break;

                default:
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {

                System.out.printf(
                    "%s: saver mode not supported%n",
                    type
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = units * Appliance.COST_PER_UNIT;

            totalCost += cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}