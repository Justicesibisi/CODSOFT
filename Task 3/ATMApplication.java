import java.util.Scanner;

// Class to represent a user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: R" + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: R" + amount);
            } else {
                System.out.println("Insufficient balance! Withdrawal failed.");
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    // Method to check the current balance
    public double getBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    // Constructor to initialize the ATM with a BankAccount object
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Display the ATM menu to the user
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Handle user input and actions
    public void start() {
        while (true) {
            displayMenu();
            System.out.print("Please choose an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.printf("Your current balance is: R%.2f\n", account.getBalance());
                case 2 -> {
                    System.out.print("Enter the amount to deposit: R");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter the amount to withdraw: R");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                }
                case 4 -> {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return; // Exit the program
                }
                default -> System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}


public class ATMApplication {
    public static void main(String[] args) {
        // Initialize a BankAccount with a starting balance
        BankAccount userAccount = new BankAccount(200.00);

        // Initialize the ATM with the user's account
        ATM atm = new ATM(userAccount);

        // Start the ATM program
        atm.start();
    }
}
