// Importing necessary packages for input and random number generation
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Initialize variables to keep track of the score and round
        int score = 0;
        boolean playAgain = true; // Variable to control multiple rounds

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) { // Start the game loop
            // Generate a random number between 1 and 100 (inclusive)
            int targetNumber = random.nextInt(100) + 1;

            // Let the user know the range
            System.out.println("\nGuess a number between 1 and 100!");

            // Limit the user to 5 attempts
            int attemptsLeft = 5;

            // Variable to track whether the user guessed correctly
            boolean guessedCorrectly = false;

            // Loop until the user guesses the correct number or runs out of attempts
            while (attemptsLeft > 0) {
                // Show remaining attempts to the user
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.print("Enter your guess: ");

                // Read the user's guess
                int userGuess = scanner.nextInt();

                // Compare the guess to the target number
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    score += 10; // Award 10 points for a correct guess
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                // Reduce the remaining attempts
                attemptsLeft--;
            }

            // If the user didn't guess correctly, show the target number
            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts! The correct number was: " + targetNumber);
            }

            // Display the user's current score
            System.out.println("Your score: " + score);

            // Ask if the user wants to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            // If the user types "no", exit the game loop
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        // Thank the user for playing
        System.out.println("Thank you for playing! Your final score is: " + score);

        // Close the Scanner to free resources
        scanner.close();
    }
}
