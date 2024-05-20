import java.util.ArrayList;
import java.util.Scanner;

class Bank {
    static int totalBalance = 0;
    static int totalLoan = 0;
    static boolean loanStatus = true;
    static ArrayList<Account> accountList = new ArrayList<>();
    String name;

    public Bank(String name) {
        this.name = name;
    }

    public int generateAutoAccNumber() {
        return (int) (Math.random() * (200 - 100 + 1) + 100);
    }

    public Account createAccount(String name, String email, String password, String accountType) {
        int accountNumber = generateAutoAccNumber();
        Account user;
        switch (accountType) {
            case "Savings":
                user = new SavingsAccount(name, email, password, accountNumber);
                break;
            case "Current":
                user = new CurrentAccount(name, email, password, accountNumber);
                break;
            case "Admin":
                user = new Admin(name, email, password, accountNumber);
                break;
            default:
                System.out.println("Invalid account type!");
                return null;
        }
        accountList.add(user);
        return user;
    }

    public void deleteAccount(int accountNumber) {
        for (Account user : accountList) {
            if (user.accountNumber == accountNumber) {
                accountList.remove(user);
                totalBalance -= user.balance;
                totalLoan -= user.loans;
                System.out.println("Account with account number " + accountNumber + " deleted.");
                return;
            }
        }
        System.out.println("Account with account number " + accountNumber + " not found.");
    }

    public void showUsers() {
        for (Account user : accountList) {
            System.out.println("Name : " + user.name + " || Email : " + user.email + " || Account Type : " + user.accountType + " || Account Number : " + user.accountNumber);
        }
    }

    public void totalBalances() {
        int total = 0;
        for (Account user : accountList) {
            System.out.println("Name: " + user.name + " || Account Number: " + user.accountNumber + " || Balance: " + user.balance);
            total += user.balance;
        }
        System.out.println("Total Balance: " + total);
    }

    public void totalLoans() {
        for (Account user : accountList) {
            System.out.println("Name: " + user.name + " || Account Number: " + user.accountNumber + " || Loans: " + user.loans);
        }
        System.out.println("Total Loans: " + totalLoan);
    }

    public void loansStatus(int accountNumber, boolean status) {
        for (Account user : accountList) {
            if (user.accountNumber == accountNumber) {
                user.setLoanStatus(status);
                return;
            }
        }
        System.out.println("User with account number " + accountNumber + " not found.");
    }
}

class Account {
    String name, email, password, accountType;
    int accountNumber, balance = 0, loans = 0, loanCount = 2;
    boolean loanStatus = true;
    ArrayList<String> transactionHistory = new ArrayList<>();

    public Account(String name, String email, String password, int accountNumber, String accountType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit " + amount);
            Bank.totalBalance += amount;
            System.out.println("Deposited " + amount + " taka. Now your balance is " + balance + " taka.");
        } else {
            System.out.println("Invalid balance!");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            Bank.totalBalance -= amount;
            transactionHistory.add("Withdraw " + amount);
            System.out.println("Withdrawn " + amount + " taka. Now your balance is " + balance + " taka.");
        } else {
            System.out.println("Not enough money in your account. Please deposit first!");
        }
    }

    public void checkAvailableBalance() {
        System.out.println("Your current balance is " + balance + " taka.");
    }

    public void checkTransactionHistory() {
        System.out.println("Transaction History: " + transactionHistory);
    }

    public void transfer(int amount, int receive) {
        Account other = null;
        for (Account user : Bank.accountList) {
            if (user.accountNumber == receive) {
                other = user;
                break;
            }
        }
        if (amount > 0 && balance >= amount && other != null) {
            balance -= amount;
            other.balance += amount;
            transactionHistory.add("Transferred: " + amount + " to " + other.name);
            System.out.println("Transferred " + amount + " taka to " + other.name + " successfully.");
        } else {
            System.out.println("Error: Insufficient balance for transfer.");
        }
    }

    public void setLoanStatus(boolean status) {
        loanStatus = status;
        System.out.println("Loan status for " + name + " is now " + (status ? "Enabled" : "Disabled") + ".");
    }

    public void takeLoan(int amount) {
        if (loanCount > 0 && loanStatus && loanCount < 3) {
            balance += amount;
            loans += amount;
            Bank.totalLoan += amount;
            transactionHistory.add("Loan taken: " + amount);
            System.out.println("Loan of " + amount + " taka credited to your account. Your balance is " + balance + ".");
            loanCount -= 1;
        } else if (!loanStatus) {
            System.out.println("Loan feature is currently turned off by the bank.");
        } else {
            System.out.println("You have already taken the maximum number of loans.");
        }
    }

    public void showInfo() {
        System.out.println("Information of " + accountType + " account by " + name);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Name: " + name);
        System.out.println("Email Address: " + email);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + balance);
        System.out.println("Loan Taken: " + loans);
        System.out.println("Transaction History: " + transactionHistory);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String name, String email, String password, int accountNumber) {
        super(name, email, password, accountNumber, "Savings");
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String name, String email, String password, int accountNumber) {
        super(name, email, password, accountNumber, "Current");
    }
}

class Admin extends Account {
    public Admin(String name, String email, String password, int accountNumber) {
        super(name, email, password, accountNumber, "Admin");
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Pubali Bank");
        System.out.println(bank.name);
        Account currentUser = null;
        Admin admin = null;

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            if (admin == null) {
                System.out.println("No admin logged in!");
                System.out.print("Register or Login? (R/L): ");
                String ch = scanner.next();
                if (ch.equalsIgnoreCase("R")) {
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter your email: ");
                    String email = scanner.next();
                    System.out.print("Enter your password: ");
                    String password = scanner.next();
                    System.out.print("Admin? (Admin): ");
                    String accountType = scanner.next();
                    if (accountType.equals("Admin")) {
                        admin = (Admin) bank.createAccount(name, email, password, accountType);
                    }
                } else if (ch.equalsIgnoreCase("L")) {
                    System.out.print("Enter your username: ");
                    String name = scanner.next();
                    System.out.print("Enter your password: ");
                    String password = scanner.next();
                    for (Account account : Bank.accountList) {
                        if (account.name.equals(name) && account.password.equals(password)) {
                            admin = (Admin) account;
                            break;
                        } else if (!account.password.equals(password)) {
                            System.out.println("Incorrect password!");
                        }
                    }
                }
            } else {
                System.out.println("Welcome " + admin.name);
                if (admin.accountType.equals("Admin")) {
                    System.out.println("***Menu***");
                    System.out.println("1. Create or Log In Your Account");
                    System.out.println("2. Delete User Account");
                    System.out.println("3. User Account List");
                    System.out.println("4. Total Available Balance");
                    System.out.println("5. Total Loans");
                    System.out.println("6. Loan Status");
                    System.out.println("7. Logout");

                    int op = scanner.nextInt();

                    if (op == 1) {
                        while (true) {
                            if (currentUser == null) {
                                System.out.println("No users logged in!");
                                System.out.print("Register or Login? (R/L): ");
                                String ch = scanner.next();
                                if (ch.equalsIgnoreCase("R")) {
                                    // Registration logic
                                    System.out.print("Enter your name: ");
                                    String name = scanner.next();
                                    System.out.print("Enter your email: ");
                                    String email = scanner.next();
                                    System.out.print("Enter your password: ");
                                    String password = scanner.next();
                                    System.out.print("Savings account or Current account? (Savings/Current): ");
                                    String accountType = scanner.next();
                                    if (accountType.equals("Savings") || accountType.equals("Current")) {
                                        currentUser = bank.createAccount(name, email, password, accountType);
                                    } else {
                                        System.out.println("Invalid account type!");
                                    }
                                } else if (ch.equalsIgnoreCase("L")) {
                                    // Login logic
                                    System.out.print("Enter your email: ");
                                    String email = scanner.next();
                                    System.out.print("Enter your password: ");
                                    String password = scanner.next();
                                    for (Account account : Bank.accountList) {
                                        if (account.email.equals(email) && account.password.equals(password)) {
                                            currentUser = account;
                                            break;
                                        } else if (!account.password.equals(password)) {
                                            System.out.println("Incorrect password!");
                                        }
                                    }
                                } else {
                                    System.out.println("Invalid choice!");
                                }
                            } else {
                                System.out.println("Welcome " + currentUser.name);
                                if (currentUser.accountType.equals("Savings") || currentUser.accountType.equals("Current")) {
                                    System.out.println("***Menu***");
                                    System.out.println("1. Deposit Amount: ");
                                    System.out.println("2. Withdraw Amount: ");
                                    System.out.println("3. Check Available Balance: ");
                                    System.out.println("4. Transaction History: ");
                                    System.out.println("5. Transfer Balance: ");
                                    System.out.println("6. Take Loan: ");
                                    System.out.println("7. Show Information List: ");
                                    System.out.println("8. Logout: ");

                                    int option = scanner.nextInt();

                                    if (option == 1) {
                                        System.out.print("Enter deposit amount: ");
                                        int depositAmount = scanner.nextInt();
                                        currentUser.deposit(depositAmount);
                                    } else if (option == 2) {
                                        System.out.print("Enter withdraw amount: ");
                                        int withdrawAmount = scanner.nextInt();
                                        currentUser.withdraw(withdrawAmount);
                                    } else if (option == 3) {
                                        currentUser.checkAvailableBalance();
                                    } else if (option == 4) {
                                        currentUser.checkTransactionHistory();
                                    } else if (option == 5) {
                                        System.out.print("Enter transfer amount: ");
                                        int transferAmount = scanner.nextInt();
                                        System.out.print("Enter receiver account No: ");
                                        int accountNumber = scanner.nextInt();
                                        currentUser.transfer(transferAmount, accountNumber);
                                    } else if (option == 6) {
                                        System.out.print("How much loan amount: ");
                                        int amount = scanner.nextInt();
                                        currentUser.takeLoan(amount);
                                    } else if (option == 7) {
                                        currentUser.showInfo();
                                    } else if (option == 8) {
                                        currentUser = null;
                                        break;
                                    } else {
                                        System.out.println("Invalid Choose!");
                                    }
                                }
                            }
                        }
                    } else if (op == 2) {
                        System.out.print("Enter deleting account number: ");
                        int accNumber = scanner.nextInt();
                        bank.deleteAccount(accNumber);
                    } else if (op == 3) {
                        bank.showUsers();
                    } else if (op == 4) {
                        bank.totalBalances();
                    } else if (op == 5) {
                        bank.totalLoans();
                    } else if (op == 6) {
                        System.out.println("1. Enable Loan Status");
                        System.out.println("2. Disable Loan Status");
                        int optionLoanStatus = scanner.nextInt();
                        System.out.print("Enter the account number: ");
                        int accountNumberLoanStatus = scanner.nextInt();

                        if (optionLoanStatus == 1) {
                            bank.loansStatus(accountNumberLoanStatus, true);
                        } else if (optionLoanStatus == 2) {
                            bank.loansStatus(accountNumberLoanStatus, false);
                        } else {
                            System.out.println("Invalid option for loan status.");
                        }
                    } else if (op == 7) {
                        admin = null;
                    } else {
                        System.out.println("Invalid choice!");
                    }
                }
            }
        }
    }
}
