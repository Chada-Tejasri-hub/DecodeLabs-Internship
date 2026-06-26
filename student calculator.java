import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("====================================");

        // Student Details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        String[] subjectNames = new String[subjects];
        int[] marks = new int[subjects];

        int totalMarks = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        boolean allPassed = true;

        sc.nextLine(); // consume newline

        // Input Subject Names and Marks
        for (int i = 0; i < subjects; i++) {

            System.out.print("\nEnter Subject Name " + (i + 1) + ": ");
            subjectNames[i] = sc.nextLine();

            System.out.print("Enter Marks for " + subjectNames[i] + " (0-100): ");
            marks[i] = sc.nextInt();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid Marks! Enter between 0 and 100: ");
                marks[i] = sc.nextInt();
            }

            if (marks[i] < 40) {
                allPassed = false;
            }

            totalMarks += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
            }

            sc.nextLine(); // consume newline
        }

        // Percentage
        double percentage = (double) totalMarks / subjects;

        // Grade
        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Classification
        String classification;

        if (percentage >= 75) {
            classification = "Distinction";
        } else if (percentage >= 60) {
            classification = "First Class";
        } else if (percentage >= 50) {
            classification = "Second Class";
        } else if (percentage >= 40) {
            classification = "Pass Class";
        } else {
            classification = "Fail";
        }

        // Report Card
        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("        STUDENT REPORT CARD");
        System.out.println("====================================");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);

        System.out.println("\n------------------------------------");
        System.out.printf("%-20s %-10s\n", "Subject", "Marks");
        System.out.println("------------------------------------");

        for (int i = 0; i < subjects; i++) {
            System.out.printf("%-20s %-10d\n",
                    subjectNames[i], marks[i]);
        }

        System.out.println("------------------------------------");
        System.out.println("Total Marks      : " + totalMarks);
        System.out.printf("Percentage       : %.2f%%\n", percentage);
        System.out.println("Grade            : " + grade);
        System.out.println("Highest Marks    : " + highest);
        System.out.println("Lowest Marks     : " + lowest);
        System.out.println("Classification   : " + classification);
        System.out.println("Status           : " +
                (allPassed ? "PASS" : "FAIL"));
        System.out.println("====================================");

        sc.close();
    }
}