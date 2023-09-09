import java.util.Scanner;

class Account {
    private int accNo;
    private String name;
    private double deposit;
    private String type;

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account no: ");
        System.out.println("----------------------------------------------");
        this.accNo = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter the account holder name: ");
         System.out.println("----------------------------------------------");
        this.name = scanner.nextLine();
        System.out.println("Enter the type of account [C/S]: ");
         System.out.println("----------------------------------------------");
        this.type = scanner.nextLine();
        System.out.println("Enter the initial amount (>=500  and <=1000): ");
         System.out.println("----------------------------------------------");
        
        Double x = scanner.nextDouble();
        if(x>=500 && x<=1000)
        {
            this.deposit=x;
        }
        else{
            System.out.println("Please enter initial amount acoording to rules");
        }
        System.out.println("\nAccount Created");
    }

    public void showAccount() {
        System.out.println("Account Number: " + this.accNo);
        System.out.println("--------------------");
        System.out.println("Account Holder Name: " + this.name);
        System.out.println("--------------------");
        System.out.println("Type of Account: " + this.type);
        System.out.println("--------------------");
        System.out.println("Balance: " + this.deposit);
        System.out.println("--------------------");
    }

    public void modifyAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account Number: " + this.accNo);
        System.out.println("------------------------------");
        System.out.println("Modify Account Holder Name: ");
         System.out.println("------------------------------");
        this.name = scanner.nextLine();
        System.out.println("Modify type of Account: ");
         System.out.println("------------------------------");
        this.type = scanner.nextLine();
        System.out.println("Modify Balance: ");
         System.out.println("------------------------------");
        this.deposit = scanner.nextDouble();
    }

    public void depositAmount(double amount) {
        this.deposit += amount;
    }

    public void withdrawAmount(double amount) {
        if (amount <= this.deposit) {
            this.deposit -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void report() {
        System.out.println(this.accNo + " || " + this.name + " || " + this.type + " || " + this.deposit);
    }

    public int getAccountNo() {
        return this.accNo;
    }

    public String getAccountHolderName() {
        return this.name;
    }

    public String getAccountType() {
        return this.type;
    }

    public double getDeposit() {
        return this.deposit;
    }
}

public class protecto {
    private static final int MAX_ACCOUNTS = 100;
    private static Account[] accounts = new Account[MAX_ACCOUNTS]; // Array of objects
    private static int numAccounts = 0;

    public static void intro() {
        System.out.println("\t\t\t\t**********************");
        System.out.println("\t\t\t\tBANK MANAGEMENT SYSTEM");
        System.out.println("\t\t\t\t**********************");
        System.out.println("\t\t\t\t:Your Security is our Priority:");
        System.out.println("\t\t\t\tSHARMA BANKS");
        new Scanner(System.in).nextLine();
    }

    public static void writeAccount() {
        if (numAccounts < MAX_ACCOUNTS) {
            Account account = new Account();
            account.createAccount();   // intialization of instant variables.
            accounts[numAccounts] = account; //storing the account that is being created ....
            numAccounts++;
        } else {
            System.out.println("Maximum number of accounts reached.");
        }
    }

    public static void displayAll() {
        if (numAccounts > 0) {
            for (int i = 0; i < numAccounts; i++) {   //LINEAR SEARCH IS IMPLIMENTED
                Account account = accounts[i];
                System.out.println(account.getAccountNo() + " " + account.getAccountHolderName() + " " +
                        account.getAccountType() + " " + account.getDeposit());
            }
        } else {
            System.out.println("No records to display");
        }
    }

    public static void displaySp(int num) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            Account account = accounts[i];        //Linear search is applied 
            if (account.getAccountNo() == num) {
                System.out.println("Your account Balance is = " + account.getDeposit());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No existing record with this number");
        }
    }

    public static void depositAndWithdraw(int num1, int num2) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            Account account = accounts[i];
            if (account.getAccountNo() == num1) {        //num1 for deposit
                Scanner scanner = new Scanner(System.in);
                if (num2 == 1) {
                    System.out.print("Enter the amount to deposit: ");
                    double amount = scanner.nextDouble();
                    account.depositAmount(amount);
                    System.out.println("Your account is updated");
                } else if (num2 == 2) {                 //num2 for withdrawal
                    System.out.print("Enter the amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    account.withdrawAmount(amount);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No existing record with this number");
        }
    }

    public static void deleteAccount(int num) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNo() == num) {
                for (int j = i; j < numAccounts - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                numAccounts--;
                found = true;
                System.out.println("Account deleted successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("No existing record with this number");
        }
    }

    public static void modifyAccount(int num) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            Account account = accounts[i];
            if (account.getAccountNo() == num) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the account holder name: ");
                account.modifyAccount();
                found = true;
                System.out.println("Account modified successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("No existing record with this number");
        }
    }

    public static void balanceEnquiry(int num) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            Account account = accounts[i];
            if (account.getAccountNo() == num) {
                account.showAccount();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No existing record with this number");
        }
    }

    public static void closeAccount(int num) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            Account account = accounts[i];
            if (account.getAccountNo() == num) {
                deleteAccount(num);
                found = true;
                System.out.println("Account closed successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("No existing record with this number");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ch = "";
        int num = 0;
        intro();

        while (!ch.equals("8")) {
            System.out.println("\tMAIN MENU");
            System.out.println("\t1.** NEW ACCOUNT**");
            System.out.println("\t2.** DEPOSIT AMOUNT**");
            System.out.println("\t3.** WITHDRAW AMOUNT**");
            System.out.println("\t4.** BALANCE ENQUIRY**");
            System.out.println("\t5.** ALL ACCOUNT HOLDER LIST**");
            System.out.println("\t6.** CLOSE AN ACCOUNT**");
            System.out.println("\t7.** MODIFY AN ACCOUNT**");
            System.out.println("\t8.** EXIT**");
            System.out.print("\tSelect Your Option (1-8): ");
            ch = scanner.nextLine();

            switch (ch) {
                case "1":
                    writeAccount();
                    break;
                case "2":
                    System.out.print("\tEnter The account No.: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    depositAndWithdraw(num, 1);
                    break;
                case "3":
                    System.out.print("\tEnter The account No.: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); 
                    depositAndWithdraw(num, 2);
                    break;
                case "4":
                    System.out.print("\tEnter The account No.: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); 
                    balanceEnquiry(num);
                    break;
                case "5":
                    displayAll();
                    break;
                case "6":
                    System.out.print("\tEnter The account No.: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); 
                    closeAccount(num);
                    break;
                case "7":
                    System.out.print("\tEnter The account No.: ");
                    num = scanner.nextInt();
                    scanner.nextLine(); 
                    modifyAccount(num);
                    break;
                case "8":
                    System.out.println("\tThanks for using bank management system");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
