import java.util.*;

class InvalidMarksException extends Exception{
    InvalidMarksException(String s){
        super(s);
    }
}

public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking input of number of subjects !!
        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = input.nextInt();

        double[] marks = new double[numOfSubjects];
        String[] subjects = new String[numOfSubjects];

        // Taking input of Subject name and marks !!
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjects[i] = input.next();
            try {
                System.out.print("Enter the marks of subject " + (i + 1) + ": ");
                double mark=input.nextDouble();
                if (mark<=100){
                    marks[i]=mark;
                }
                else {
                    throw new InvalidMarksException("Marks cannot be greater than 100");
                }
            }
            catch(InvalidMarksException e){
                System.out.println(e);
            }
        }

        double totalMarks = calculateTotalMarks(marks);
        double percentage = calculatePercentage(totalMarks, numOfSubjects);
        char grade = calculateGrade(percentage);

        // Display of result !!
        System.out.println("Subject"+"\t\t"+"Marks");
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.println(subjects[i] + "\t\t" + marks[i]);
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }

    // Calculating Total marks
    public static double calculateTotalMarks(double[] marks) {
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }
    // Calculating Percentage
    public static double calculatePercentage(double totalMarks, int numOfSubjects) {
        return (totalMarks / numOfSubjects);
    }
    // Assigning Grade
    public static char calculateGrade(double percentage) {
        if (percentage >= 90) {
            return 'O';
        } else if (percentage >= 80) {
            return 'A';
        } else if (percentage >= 70) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 50) {
            return 'D';
        }else if (percentage >= 40) {
            return 'E';
        }
        else {
            return 'F';
        }
    }
}