import java.util.*;

public class QuizApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int TIME_LIMIT = 20; // seconds per question
    private static final int MAX_FAILS = 3; // Maximum failed attempts before game over

    static class Question {
        String question;
        String[] options;
        int correctOption;

        Question(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    // Main method
    public static void main(String[] args) {
        displayInstructions();

        // Initialize quiz questions
        List<Question> questions = initializeQuestions();

        int score = 0;
        int failedAttempts = 0;
        List<String> summary = new ArrayList<>();

        // Prompt user to start the game
        System.out.println("\nType 'start' and press Enter to begin the quiz!");
        String startCommand = scanner.nextLine();
        if (!startCommand.equalsIgnoreCase("start")) {
            System.out.println("Invalid command. Exiting the quiz.");
            return;
        }

        System.out.println("\nQuiz starts now! You have " + TIME_LIMIT + " seconds per question.\n");

        // Quiz loop
        for (int i = 0; i < questions.size(); i++) {
            if (failedAttempts >= MAX_FAILS) {
                System.out.println("\nGame Over! You reached the maximum failed attempts.");
                break;
            }

            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            // Start the timer and get user input
            int userAnswer = getUserAnswer(TIME_LIMIT);

            if (userAnswer == -1) {
                System.out.println("Time's up! Moving to the next question.\n");
                failedAttempts++;
                summary.add("Question " + (i + 1) + ": Incorrect (Timeout)");
            } else if (userAnswer == q.correctOption) {
                System.out.println("Correct!\n");
                score++;
                summary.add("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Incorrect! The correct answer was: " + q.options[q.correctOption - 1] + "\n");
                failedAttempts++;
                summary.add("Question " + (i + 1) + ": Incorrect");
            }
        }

        // Display result
        System.out.println("\nQuiz Complete!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        System.out.println("\nSummary of answers:");
        for (String result : summary) {
            System.out.println(result);
        }
    }

    // Display instructions
    private static void displayInstructions() {
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("Instructions:");
        System.out.println("1. Each question will have multiple-choice options.");
        System.out.println("2. You must answer within " + TIME_LIMIT + " seconds.");
        System.out.println("3. Type the number corresponding to your answer (e.g., 1, 2, 3, or 4).");
        System.out.println("4. You have " + MAX_FAILS + " attempts. After exceeding the limit, the game ends.");
        System.out.println("5. Your final score will be displayed at the end.\n");
    }

    // quiz questions
    private static List<Question> initializeQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of South Africa?",
                new String[] { "Pretoria", "Cape Town", "Johannesburg", "Durban" }, 1));
        questions.add(new Question("Which South African icon was released from prison in 1990?",
                new String[] { "Desmond Tutu", "Nelson Mandela", "Thabo Mbeki", "Chris Hani" }, 2));
        questions.add(new Question("Which is the largest country in Africa by area?",
                new String[] { "Sudan", "Nigeria", "Algeria", "Democratic Republic of the Congo" }, 3));
        questions.add(new Question("What is the national currency of South Africa?",
                new String[] { "Rand", "Dollar", "Pound", "Euro" }, 1));
        questions.add(new Question("Which is the longest river in the world?",
                new String[] { "Amazon", "Yangtze", "Nile", "Mississippi" }, 3));
        questions.add(new Question("In what year did South Africa host the FIFA World Cup?",
                new String[] { "2006", "2010", "2014", "2018" }, 2));
        questions.add(new Question("What is the highest mountain in Africa?",
                new String[] { "Mount Kenya", "Mount Everest", "Mount Kilimanjaro", "Table Mountain" }, 3));
        questions.add(new Question("Which famous city is known as the 'Big Apple'?",
                new String[] { "Los Angeles", "London", "New York", "Paris" }, 3));
        questions.add(new Question("Who was the first President of the Republic of South Africa?",
                new String[] { "Nelson Mandela", "Thabo Mbeki", "Jacob Zuma", "Kgalema Motlanthe" }, 1));
        questions.add(new Question("Which ocean borders the east coast of South Africa?",
                new String[] { "Atlantic Ocean", "Indian Ocean", "Southern Ocean", "Arctic Ocean" }, 2));
        return questions;
    }

    // Get user's answer with a time limit and display countdown
    private static int getUserAnswer(int timeLimit) {
        Timer timer = new Timer();
        boolean[] timedOut = { false }; // To track if time is up
        TimerTask task = new TimerTask() {
            int countdown = timeLimit;

            @Override
            public void run() {
                if (countdown > 0) {
                    System.out.print("\rTime remaining: " + countdown + " seconds ");
                    countdown--;
                } else {
                    System.out.println("\nTime's up!");
                    timedOut[0] = true;
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000); // Start countdown timer

        try {
            System.out.print("\nEnter your answer (1-4): ");
            int answer = scanner.nextInt();
            if (!timedOut[0]) {
                timer.cancel(); // Stop timer if answered in time
                return answer;
            } else {
                return -1;
            }
        } catch (InputMismatchException e) {
            scanner.next(); // Clear invalid input
            System.out.println("Invalid input! Moving to the next question.\n");
            return -1;
        } finally {
            timer.cancel();
        }
    }
}
