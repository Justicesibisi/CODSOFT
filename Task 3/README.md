ATM Machine Simulation

This program simulates the basic functionality of an ATM machine. It allows users to interact with their bank account to perform operations such as checking their balance, depositing money, and withdrawing funds. The system ensures user input is validated and displays appropriate messages for each action.

Features
Bank Account Class:

Stores and manages the user's account balance.
Provides methods to deposit and withdraw money with validation.
ATM Class:

Represents the ATM machine.
Offers a menu-driven interface with the following options:
Check Balance
Deposit Money
Withdraw Money
Exit
Input Validation:

Ensures that withdrawal amounts do not exceed the account balance.
Validates that deposit and withdrawal amounts are positive.
User-Friendly Feedback:

Displays clear success or failure messages for all operations.
How to Run the Program
Ensure that Java is installed on your system.
Clone or download this repository.
Compile and run the ATMApplication.java file.
Compilation and Execution Commands
bash
Copy code
javac ATMApplication.java
java ATMApplication
Usage Instructions
On running the program, the ATM menu will be displayed.
Choose an option by entering the corresponding number:
1 to check your balance.
2 to deposit money.
3 to withdraw money.
4 to exit the program.
Follow the prompts for each action, such as entering the amount to deposit or withdraw.
The program will display the result of your action, including updated balance information.
Example Interaction
plaintext
Copy code
Welcome to the ATM!
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Please choose an option (1-4): 1
Your current balance is: R1000.00

Welcome to the ATM!
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Please choose an option (1-4): 2
Enter the amount to deposit: R300
Successfully deposited: R300.0

Welcome to the ATM!
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Please choose an option (1-4): 3
Enter the amount to withdraw: R500
Successfully withdrew: R500.0
Author
Justice Sibisi

License
This project is open-source. Feel free to modify and distribute it as needed.