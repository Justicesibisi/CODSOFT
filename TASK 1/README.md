NUMBER GAMENumber Guessing Game
Overview
This is a simple number guessing game implemented in Java. The game challenges the player to guess a randomly generated number within a specified range (1 to 100). The player receives feedback on their guesses and earns points based on their performance.

Features
Generates a random number between 1 and 100.
Prompts the user to guess the number.
Provides feedback if the guess is too high, too low, or correct.
Displays hints about whether the target number is even, odd, or prime.
Awards 2 points for correctly guessing the number.
Grants 0.5 points if the guess is close (within 1 of the target) but incorrect, but only once per round.
The user can play multiple rounds. If they fail to guess the number within the allowed attempts, the game ends for that round.
The game resets the score when the user chooses to play again after failing a round.
How to Play
Run the program in a Java development environment.
Follow the prompts to guess the number.
Use the hints provided to make an educated guess.
Earn points by guessing correctly or by getting close to the correct number.
After each round, choose whether to play again or end the game.
Scoring Rules
2 points for guessing the correct number.
0.5 points for being close (within 1 of the target) if you fail to guess the correct number, awarded only once per round.
Installation
Ensure you have Java installed on your system.
Clone or download the repository.
Compile and run the NumberGuessingGame.java file using your Java development environment or command line.
bash
Copy code
javac NumberGuessingGame.java
java NumberGuessingGame
Usage
Run the program and follow the on-screen prompts to guess the number. The game will continue until the user decides to stop playing.

Example
plaintext
Copy code
Welcome to the Number Guessing Game!

Scoring Rules:
 - Earn 2 points for guessing the correct number.
 - Earn 0.5 points for being very close (within 1 of the target) if you fail to guess the number.
 - Your score resets if you play again after failing a round.
 - Proceed to the next level when you guess correctly.

Hints about the number you are looking for:
 - It is even.
 - It is not a prime number.

Guess a number between 1 and 100!
Attempts left: 5
Enter your guess: 50
Too high!
Attempts left: 4
Enter your guess: 49
Almost! You're very close.
...
Author
Justice Sibisi

License
This project is open-source. You are free to use, modify, and distribute it as needed.