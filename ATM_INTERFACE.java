import java.util.*;
public class ATM_INTERFACE {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.performTransactions();
    }

    static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public boolean withdraw(double amount) {
            if (amount > balance) {
                return false;
            }
            balance -= amount;
            return true;
        }

        public void deposit(double amount) {
            balance += amount;
        }
    }

    static class ATM {
            private BankAccount account;
            private Scanner input;

            public ATM(BankAccount account) {
                this.account = account;
                this.input = new Scanner(System.in);
            }

            public void performTransactions() {
                while (true) {
                    System.out.println("Please choose an option:");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Exit");

                    int option = input.nextInt();

                    switch (option) {
                        case 1 -> checkBalance(); // Calls checkBalance method
                        case 2 -> withdraw();  // Calls withdraw method
                        case 3 -> deposit();// Calls deposit method
                        case 4 -> {
                            System.out.print("Thank you for using the ATM !! ");
                            return;
                        }
                        default -> System.out.print("Invalid option. Please try again.");
                    }
                }
            }
        // Method to check account balance
            private void checkBalance() {
                System.out.print("Your current balance is: Rs " + account.getBalance());
            }
        // Method to withdraw money from account
            private void withdraw() {
                System.out.print("Enter the amount you want to withdraw: ");
                double amount = input.nextDouble();

                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal successful. Your new balance is: Rs " + account.getBalance());
                } else {
                    System.out.println("Withdrawal failed. Insufficient balance.");
                }
            }
            // Method to deposit money to account
            private void deposit() {
                System.out.print("Enter the amount you want to deposit: ");
                double amount = input.nextDouble();
                account.deposit(amount);
                System.out.println("Deposit successful. Your new balance is: Rs " + account.getBalance());
            }
        }
}