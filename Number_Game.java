import java.util.*;
public class Number_Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int maxAttempts = 10,totalrounds=0,score = 0;

        System.out.println("Welcome to the Number Guessing Game !!");

        while (true) {
            int numberToGuess = rand.nextInt(100);
            int attempts = 0;

            System.out.println("Guess a number between 1 & 100.");

            while (attempts < maxAttempts) {
                try {
                    System.out.print("Guess the number: ");
                    int userGuess = input.nextInt();
                    if(userGuess < 1 ||userGuess > 100){
                        throw new InputMismatchException("Guess is out of range !!");
                    }
                    attempts++;
                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                        score++;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    if (attempts == maxAttempts) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + numberToGuess + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine();
                }
            }
            totalrounds++;
            System.out.println(" ");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = input.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println(" ");
                if(score==1){
                    System.out.println("You won " + score + " round out of "+totalrounds+" played.");
                }
                else {
                    System.out.println("You won " + score + " rounds out of "+totalrounds+" played.");
                }
                break;
            }
        }
        input.close();
    }
}