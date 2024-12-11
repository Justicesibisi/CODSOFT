import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display grade criteria at the start
        System.out.println("Grade Criteria:");
        System.out.println("80-100%: Excellent (A) : Outstanding performance.");
        System.out.println("70-79%: Very Good (B) : Above average.");
        System.out.println("60-69%: Good (C) : Solid performance, meeting expectations.");
        System.out.println("50-59%: Satisfactory (D) : Pass, but with room for improvement.");
        System.out.println("40-49%: Adequate (E) : Marginal pass; student has met minimum requirements, but performance is weak.");
        System.out.println("0-39%: Fail (F) : Does not meet minimum requirements and is considered a fail.");
        
        // Prompt user for the number of subjects
        System.out.print("\nEnter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0; // To hold the sum of all marks

        // Loop to take input for each subject's marks
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            
            // Validate input to ensure marks are between 0 and 100
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                i--; // Decrease i to re-enter marks for the same subject
            } else {
                totalMarks += marks; // Add valid marks to totalMarks
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine grade based on average percentage
        String grade;
        if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else if (averagePercentage >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.println("\nTotal Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
