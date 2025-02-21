import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        double score = 0; // Using double to handle half-point scores
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("\nScoring Rules:");
        System.out.println(" - Earn 2 points for guessing the correct number.");
        System.out.println(" - Earn 0.5 points for being very close (within 1 of the target) if you fail to guess the number.");
        System.out.println(" - Your score resets if you play again after failing a round.");
        System.out.println(" - Proceed to the next level when you guess correctly.");
        
        while (playAgain) {
            boolean guessedCorrectly = false;

            while (true) { // Loop for levels
                int targetNumber = random.nextInt(100) + 1;
                int attemptsLeft = 5; // Reset attempts for each new level
                boolean closeBonusUsed = false; // To track if 0.5 bonus for "almost" was awarded

                // Provide hints about the target number
                System.out.println("\nHints about the number you are looking for:");
                System.out.println(" - It is " + (targetNumber % 2 == 0 ? "even" : "odd") + ".");
                if (isPrime(targetNumber)) {
                    System.out.println(" - It is a prime number.");
                } else {
                    System.out.println(" - It is not a prime number.");
                }

                System.out.println("\nGuess a number between 1 and 100!");

                while (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        score += 2; // Full 2 points for guessing correctly
                        guessedCorrectly = true;
                        break; // Break out of attempts loop to move to the next level
                    } else if (!closeBonusUsed && Math.abs(userGuess - targetNumber) == 1) {
                        System.out.println("Almost! You're very close.");
                        closeBonusUsed = true; // Mark that the "almost" feedback was given
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Too low!");
                    }
                    attemptsLeft--;
                }

                if (!guessedCorrectly) {
                    if (closeBonusUsed) {
                        score += 0.5; // Award 0.5 points if the user was close but failed
                    }
                    System.out.println("The correct number was: " + targetNumber);
                    System.out.println("Game over! Your total score was: " + score);
                    break; // Exit the level loop to ask if they want to play again
                }

                // If guessed correctly, proceed to the next level
                System.out.println("Your score: " + score);
                System.out.println("Proceeding to the next level...");
                guessedCorrectly = false; // Reset correct guess status for the next level
            }

            // Ask if the user wants to play again after failing
            System.out.print("Play again? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            } else {
                score = 0; // Secretly reset score without informing the user
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    // Function to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
