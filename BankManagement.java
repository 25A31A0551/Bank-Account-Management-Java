import java.util.Scanner;

public class BankManagement {

    private String accountHolder;
    private long accountNumber;
    private double balance;

    public BankManagement(String accountHolder, long accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public void displayAccount() {
        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
    }

    public void deposit(double amount) {
        if (amount > 0 && Double.isFinite(amount)) {
            balance += amount;
            System.out.printf("Deposit successful! Balance: Rs. %.2f%n", balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful! Balance: Rs. %.2f%n", balance);
        }
    }

    public void checkBalance() {
        System.out.printf("Available Balance: Rs. %.2f%n", balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("  BANK ACCOUNT MANAGEMENT");
        System.out.println("================================");

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        long accNo;

        while (true) {
            System.out.print("Enter account number: ");

            if (sc.hasNextLong()) {
                accNo = sc.nextLong();

                if (accNo > 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Enter a valid positive account number.");
        }

        double initialBalance;

        while (true) {
            System.out.print("Enter initial deposit (Rs.): ");

            if (sc.hasNextDouble()) {
                initialBalance = sc.nextDouble();

                if (Double.isFinite(initialBalance) && initialBalance >= 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Enter a valid non-negative amount.");
        }

        BankManagement account = new BankManagement(name, accNo, initialBalance);

        int choice;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccount();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");

                    if (sc.hasNextDouble()) {
                        account.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount.");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");

                    if (sc.hasNextDouble()) {
                        account.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount.");
                        sc.next();
                    }
                    break;

                case 4:
                    account.checkBalance();
                    break;

                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
                                           }
