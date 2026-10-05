import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    private static final double BOOKING_FEE = 50.0;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends TravelBooking {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends TravelBooking {

    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            TravelBooking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);
            } 
            else if (mode.equals("TRAIN")) {
                booking = new Train(distance);
            } 
            else {
                booking = new Flight(distance);
            }

            System.out.printf(
                "%s: %.2f%n",
                mode,
                booking.calculateTotal()
            );
        }

        sc.close();
    }
}