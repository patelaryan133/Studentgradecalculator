import java.util.Scanner;

public class StudentGradeCalculator {
    static int readMarks(Scanner sc, String prompt) {
        int m;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                m = sc.nextInt();
                if (m >= 0 && m <= 100) return m;
            } else {
                sc.next();
            }
            System.out.println("Enter marks between 0 and 100.");
        }
    }

    static String grade(double avg) {
        if (avg >= 90) return "A+";
        if (avg >= 80) return "A";
        if (avg >= 70) return "B";
        if (avg >= 60) return "C";
        if (avg >= 50) return "D";
        if (avg >= 40) return "E";
        return "F (Fail)";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter number of subjects: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid. Enter number of subjects: ");
                sc.next();
            }
            n = sc.nextInt();
        } while (n <= 0);

        int total = 0;
        for (int i = 1; i <= n; i++) total += readMarks(sc, "Marks for subject " + i + " (out of 100): ");

        double avg = (double) total / n;
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + total + " / " + (n * 100));
        System.out.printf("Average Percentage: %.2f%%%n", avg);
        System.out.println("Grade: " + grade(avg));
        sc.close();
    }
}
