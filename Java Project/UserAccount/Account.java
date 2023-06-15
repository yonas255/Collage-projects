package UserAccount;


import java.util.Scanner;
public class Account {
    private int userID;
    private String userName;
    private int userPin;
    private int userBalance;
    public static String userInput;
   
    
    public static int count = 3;
    static Scanner input = new Scanner(System.in);
    static SavingAccount[] sAcc = new SavingAccount[3];
    static CurrentAccount[] cAcc = new CurrentAccount[3];

    public Account(int userID, String userName, int userPin, int userBalance) {
        this.userID = userID;
        this.userName=userName;
        this.userPin=userPin;
        this.userBalance=userBalance;
    }

    public Account() {}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPin() {
        return userPin;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "ID:"+ userID + "  Name:" + userName + "  Pin:" + userPin + "  Balance:" + userBalance;
    }
    public void sLogin() {
        sAcc[0]=new SavingAccount(1,"Joshua",4125, 3000);
        sAcc[1]=new SavingAccount(2,"Eskandar",2134, 2000);
        sAcc[2]=new SavingAccount(3,"Yonas",1234, 1000);
        System.out.println("Enter your Pin: ");
        userInput = input.next();
        errorCheck();
        int pin = Integer.parseInt(userInput);
        for(int i=0;i<sAcc.length;i++) {
            if (pin == sAcc[i].getUserPin()) {
                sAcc[i].sAccMenu();
            }
        }
        for(int i=0;i<sAcc.length;i++) {
            if (pin != sAcc[i].getUserPin()) {
                System.out.println("Invalid PIN");
                countExit();
                sLogin();
            }
        }
    }
    public void cLogin() {
        cAcc[0]=new CurrentAccount(1,"Tupas",5214, 3000);
        cAcc[1]=new CurrentAccount(2,"Atrakchi",4312, 2000);
        cAcc[2]=new CurrentAccount(3,"Haftom",4321, 1000);
        System.out.println("Enter your Pin: ");
        userInput = input.next();
        errorCheck();
        int pin = Integer.parseInt(userInput);
        for(int i=0;i<cAcc.length;i++) {
            if (pin == cAcc[i].getUserPin()) {
                cAcc[i].cAccMenu();
            }
        }
        for(int i=0;i<cAcc.length;i++) {
            if (pin != cAcc[i].getUserPin()) {
                System.out.println("Invalid PIN");
                countExit();
                cLogin();
            }
        }
    }

    public void sAccMenu(){
        System.out.println("Welcome to the world of Bank ATM");
        System.out.println("Please select number of the option");
        while(true) {
            System.out.println("1.Bank Statement\n2.Withdraw Money\n3.Deposit Money\n4.Change Pin\n5.Exit");
            userInput = input.next();
            errorCheck();
            int option = Integer.parseInt(userInput);
            switch(option) {
                case 1: System.out.println(toString()); break;
                case 2: AccWithdraw(); break;
                case 3: AccDeposit(); break;
                case 4: sAccChangepin(); break;
                case 5: System.exit(0); break;
                default:
                    System.out.println("Go back!");
            }
        }//end while loop
    }
    public void cAccMenu(){
        System.out.println("Welcome to the world of Bank ATM");
        System.out.println("Please select number of the option");
        while(true) {
            System.out.println("1.Bank Statement\n2.Withdraw Money\n3.Deposit Money\n4.Change Pin\n5.Exit");
            userInput = input.next();
            errorCheck();
            int option = Integer.parseInt(userInput);
            switch(option) {
                case 1: System.out.println(toString()); break;
                case 2: AccWithdraw(); break;
                case 3: AccDeposit(); break;
                case 4: cAccChangepin(); break;
                case 5: System.exit(0); break;
                default:
                    System.out.println("Go back!");
            }
        }//end while loop
    }

    public void AccWithdraw(){
        System.out.println("How much you want to withdraw money?");
        userInput = input.next();
        errorCheck();
        int Amount = Integer.parseInt(userInput);
        userBalance = (int) ((int) userBalance - Amount-( ((0.01) * Amount)));
        System.out.println("Current Balance: "+getUserBalance());
    }

    public void AccDeposit(){
        System.out.println("How much you want to deposit money?");
        userInput = input.next();
        errorCheck();
        int Amount = Integer.parseInt(userInput);
        userBalance = userBalance + Amount;
        System.out.println("Current Balance: "+getUserBalance());
    }

    public void sAccChangepin(){
        System.out.println("Enter your Pin: ");
        userInput = input.next();
        errorCheck();
        int changePin = Integer.parseInt(userInput);
        for(int i=0;i<sAcc.length;i++) {
            if (changePin == sAcc[i].getUserPin()) {
                System.out.println("Pin is already existed, please try enter again");
                sAcc[i].sAccChangepin();
            }
        }
        for(int i=0;i<sAcc.length;i++) {
            if (changePin != sAcc[i].getUserPin()) {
                userPin=userPin+changePin-userPin;
                System.out.println("Your pin is now: "+getUserPin());
                sAccMenu();
            }
        }
    }

    public void cAccChangepin(){
        System.out.println("Enter your Pin: ");
        userInput = input.next();
        errorCheck();
        int changePin = Integer.parseInt(userInput);
        for(int i=0;i<cAcc.length;i++) {
            if (changePin == cAcc[i].getUserPin()) {
                System.out.println("Pin is already existed, please try enter again");
                cAcc[i].cAccChangepin();
            }
        }
        for(int i=0;i<cAcc.length;i++) {
            if (changePin != cAcc[i].getUserPin()) {
                userPin=userPin+changePin-userPin;
                System.out.println("Your pin is now: "+getUserPin());
                cAccMenu();
            }
        }
    }

    public void errorCheck(){
        while(!userInput.matches("\\d+")){
            System.out.println("Error, numbers only");
            System.out.println("Please enter again");
            userInput = input.next();
        }//end while
    }//

    public void countExit(){
        count--;
        System.out.println("Count: "+count);
        if(count==0){
            System.out.println("Sorry no more attempts!");
            System.exit(0);
        }//end if
    }//end method
}

