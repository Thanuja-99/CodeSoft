import java.util.Scanner;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public String deposit(double amount) {
        this.balance += amount;
        return "Deposit of $" + amount + " successful. Current balance: $" + this.balance;
    }

    public String withdraw(double amount) {
        if (amount > this.balance) {
            return "Insufficient funds. Withdrawal failed.";
        } else {
            this.balance -= amount;
            return "Withdrawal of $" + amount + " successful. Current balance: $" + this.balance;
        }
    }

    public String checkBalance() {
        return "Current balance: $" + this.balance;
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);  // Initial balance of $1000
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Quit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayOptions();
            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    System.out.println(account.withdraw(withdrawAmount));
                    break;
                case "2":
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    System.out.println(account.deposit(depositAmount));
                    break;
                case "3":
                    System.out.println(account.checkBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }
}
