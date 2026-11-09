import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeCalculator extends JFrame implements ActionListener {

    JTextField nameField, physicsField, chemistryField, mathsField;
    JTextField totalField, averageField, gradeField;
    JButton calculateButton, clearButton;

    StudentGradeCalculator() {
        setTitle("Calculate Your Grade");
        setSize(450, 350);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Your Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Physics:"));
        physicsField = new JTextField();
        add(physicsField);

        add(new JLabel("Chemistry:"));
        chemistryField = new JTextField();
        add(chemistryField);

        add(new JLabel("Maths:"));
        mathsField = new JTextField();
        add(mathsField);

        add(new JLabel("Total Marks:"));
        totalField = new JTextField();
        totalField.setEditable(false);
        add(totalField);

        add(new JLabel("Average:"));
        averageField = new JTextField();
        averageField.setEditable(false);
        add(averageField);

        add(new JLabel("Grade:"));
        gradeField = new JTextField();
        gradeField.setEditable(false);
        add(gradeField);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        add(calculateButton);
        add(clearButton);

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            nameField.setText("");
            physicsField.setText("");
            chemistryField.setText("");
            mathsField.setText("");
            totalField.setText("");
            averageField.setText("");
            gradeField.setText("");
            return;
        }

        try {
            String name = nameField.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter your name");
                return;
            }

            int p = Integer.parseInt(physicsField.getText().trim());
            int c = Integer.parseInt(chemistryField.getText().trim());
            int m = Integer.parseInt(mathsField.getText().trim());

            if (p < 0 || p > 100 || c < 0 || c > 100
                    || m < 0 || m > 100) {
                JOptionPane.showMessageDialog(
                    this, "Marks must be between 0 and 100");
                return;
            }

            int total = p + c + m;
            double average = total / 3.0;
            String grade;

            if (average >= 90)
                grade = "A";
            else if (average >= 75)
                grade = "B";
            else if (average >= 60)
                grade = "C";
            else if (average >= 50)
                grade = "D";
            else
                grade = "F";

            totalField.setText(String.valueOf(total));
            averageField.setText(String.format("%.2f", average));
            gradeField.setText(grade);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Enter valid numeric marks");
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}