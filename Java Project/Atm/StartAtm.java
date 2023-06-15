package Atm;
public class StartAtm {//class start
	CurrentAccount CurAcc = new CurrentAccount();//create an object for class currentAccount
	SavingAccount SavAcc = new SavingAccount ();//create an object for class SavingAccount
	
	public static void main(String[] args) {// Create main method to be able to run the code in Account class
	        Account CallMe$= new Account();//create an object for Super class Account
	        CallMe$.startATM();//call login method
	    				
	}//end main method
}//end class
	

