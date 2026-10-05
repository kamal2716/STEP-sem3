import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate renewalDate();
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate date) {
        super(name, date);
    }

    LocalDate renewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate date) {
        super(name, date);
    }

    LocalDate renewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate date) {
        super(name, date);
    }

    LocalDate renewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan plan;

            if (type.equals("BASIC"))
                plan = new BasicPlan(name, date);
            else if (type.equals("STANDARD"))
                plan = new StandardPlan(name, date);
            else
                plan = new PremiumPlan(name, date);

            System.out.println(name + ": " + plan.renewalDate());
        }
    }
}