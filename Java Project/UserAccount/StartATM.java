package UserAccount;


import java.util.Scanner;

public class StartATM {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println("Welcome to the world of Bank ATM");
        System.out.println("Please select number of the account");
        System.out.println("1.Savings Account\n2.Current Account\n3.Exit\n");
        account.userInput = input.next();
        account.errorCheck();
        int option = Integer.parseInt(account.userInput);
        switch(option) {
            case 1: account.sLogin(); break;
            case 2: account.cLogin(); break;
            case 3: System.out.println("See you!!!"); System.exit(0); break;
            default:
                System.out.println("Select number 1, 2, or 3 only!!!");
        }
    }

}

