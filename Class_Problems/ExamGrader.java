import java.util.*;

abstract class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer, String studentAnswer,
             double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String correctAnswer, String studentAnswer,
        double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return studentAnswer.equals(correctAnswer)
                ? points : 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(String correctAnswer, String studentAnswer,
              double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return studentAnswer.equals(correctAnswer)
                ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correctAnswer, String studentAnswer,
          double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String answer = studentAnswer.toLowerCase();

        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class ExamGrader {

    static String[] parse(String line) {
        ArrayList<String> parts = new ArrayList<>();
        boolean insideQuotes = false;
        StringBuilder current = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (c == '"') {
                insideQuotes = !insideQuotes;
            } else if (c == ' ' && !insideQuotes) {
                if (current.length() > 0) {
                    parts.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0)
            parts.add(current.toString());

        return parts.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = parse(line);

            String type = p[0];

            String correct = p[2];
            String student = p[3];
            double points = Double.parseDouble(p[4]);

            Question question;

            if (type.equals("MCQ")) {
                question =
                    new MCQ(correct, student, points);
            } else if (type.equals("TF")) {
                question =
                    new TrueFalse(correct, student, points);
            } else {
                question =
                    new Essay(correct, student, points);
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}