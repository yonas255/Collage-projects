package Atm;

public class SavingAccount extends Account{

	public SavingAccount() {// create constructor to initialise the value of attributes of  Account class.
		super();// this method can able to call all the methods that Account class have.
	}
	//create a constror to let SavingAccount class know this class will initiate the values from Account class
	  public  SavingAccount(int usersId,String UsersName,int  UsersPin, double UsersBalance ) {
   	   super(usersId,UsersName,UsersPin,UsersBalance);
      }
	 
	public static void SavingAccountMenu() {//this method will display Current account  menu on the screen
		// system will display the user name on the screen
		System.out.println("Welcome To Your Saving Account: "+UseAcc[index].getUsersName());
		System.out.println("");
	while (true) {// while loop will loop though the code if the condition is True
		//ask the  user to choose from 1-5 option
		System.out.println("\t\t       PLEASE CHOOSE THE FOLLOWING OPTIONS: ");
		System.out.println("\t\t*******************************************************");				
		System.out.println("1.display Bank details.");
		System.out.println("2.Loage money.");
		System.out.println("3.WithDraw.");
		System.out.println("4.Change Pin.");
		System.out.println("5.Back TO The Main Menu.");
		System.out.println("6.Log out.");
		//take user input
		String option = input.next();
		//switch statement to choose option
		switch(option) {//Switch case to execute option code
		case "1":
			Bankstatement(); break;// this will breaks out of the switch block
		case "2":
			depositWithInterest();break;
		case "3":
			SavingAccwithdraw() ;break;
		case "4":
			ChangePin();break;
		case "5":
			optionMenu();break;
		case "6":
			logout();break;
		//default to run code if there is no case match
		default:System.out.println ("ivalid option please enter eithet 1,2,3,4,5 or 6"); 
		AttemptsMethod();//call attempt method to give chances to user
		}//end switch
	}//end while loop	
}//end savingAccount method
	public static  void depositWithInterest() {//create deposit method for Saving Account 
		//Ask the user to enter how much they want to deposit 
		System.out.println("HOW MUCH ARE YOU DEPOSITING");
		Userinput=input.next();//take user input
		errorcheckMethod();//check if its NUMBERS ONLY
		//Changing user input to INT
		int money=Integer.parseInt(Userinput);//Declare a variable INT and change it to String
		//this statement will add 0.01% per a euro of interest to the amount user input 
		UseAcc[index].setUsersBalance (UseAcc[index].getUsersBalance()+ money +( ((0.01) * money)));
		//display the fee been taken and  how much the user have
		System.out.println("Interst Added is : "+( ((0.01) * money))+"€");
		System.out.println("New Balance:"+ UseAcc[index].getUsersBalance()+"€");
	}//end depositWithInterest method
	
	 public static  void SavingAccwithdraw() {// withdraw method
			//ask the user how much want to withdraw
			System.out.println("HOW MUCH MONEY ARE YOU WITHDRAW");
			//take user input
			Userinput=input.next();
			errorcheckMethod();//check if its NUMBERS ONLY
			//change users input from int TO string 
			int currency=Integer.parseInt(Userinput);
			// this statement will subtract the amount user input from their money they had and 0.01% of fee per a euro
			UseAcc[index].setUsersBalance(UseAcc[index].getUsersBalance()- currency);
			System.out.println("You now have: " + UseAcc[index].getUsersBalance());	//Print user Balance
			System.out.println("_______________________________");
		}// end Withdrawal Method
	
	
	}//end class
