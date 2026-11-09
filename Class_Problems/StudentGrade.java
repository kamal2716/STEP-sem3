
import java.util.Scanner;
import java.util.Locale;

class StudentGrade {
    String name;
    int[] marks;

    StudentGrade(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total / 3.0;
    }

    char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void displayResult() {
        double average = calculateAverage();
        char grade = calculateGrade(average);

        System.out.printf(
            Locale.US, "%s: Average %.1f, Grade %c%n",
            name.toUpperCase(), average, grade
        );
    }
}

