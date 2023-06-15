package Atm;
import java.util.Scanner;//Scanner class from the Java utilities library 
public class Account {//start a class
	
	// Declaring variables as private
	private int usersId;
	private String UsersName;
	private double UsersBalance;
	private long UsersPin;
	static  int index; //the flag to get correct user
	static  String Userinput;//for error check method
	static  int counter=3;//number of login attempt
	static  Scanner input=new Scanner(System.in);// create an object for scanner to get users input
	static  Account UseAcc[] = new Account[6];//Create an object 
	
	
	//create  a constructor to intalize the values of private constant
	public Account(int usersId,String UsersName,int  UsersPin, double UsersBalance ) {
		this.usersId = usersId;
		this.UsersName= UsersName;
		this.UsersPin=  UsersPin;
		this.UsersBalance =UsersBalance;
	}//end constructor
	
  //SET GETTER AND SETTER TO to access account class private constants from another class
	public int getUsersId() {	return usersId;
	}//end get
	public void setUsersId(int usersId) {	this.usersId = usersId;
	}
	public String getUsersName() {	return UsersName;
	}
	public void setUsersName(String usersName) {	UsersName = usersName;
	}
	public double getUsersBalance() {	return UsersBalance;
	}
	public void setUsersBalance(double usersBalance) {	this.UsersBalance = usersBalance;
	}
	public long getUsersPin() { return UsersPin;
	}
	public  void setUsersPin(int usersPin) { UsersPin = usersPin; 
	}
	public  String getUserinput() {return Userinput;
	}
	public  void setUserinput(String userinput) { Userinput = userinput; 
	}//end set
	

	//created a constructor with no arguments  which we use to initialise the attributes defined in the Account class. 
	public Account() {	
	}//end constructor


	public void startATM() {//Login method 
		//store the values for each index
		UseAcc [0] = new Account(01,"yonas", 1234, 1000);
		UseAcc [1] = new Account(02,"John",  2345, 2000);
		UseAcc [2] = new Account(03,"Sam",   3456, 3000);
		UseAcc [3] = new Account(04,"jacob", 4567, 4000);
		UseAcc [4] = new Account(05,"Teler", 5678, 5000);
		UseAcc [5] = new Account(06,"Jack",  6789, 6000); 
		
		System.out.println("\t\t\t_______________________");
		//ask the user to enter pin or password
		System.out.println("\t\t\tPlease enter your pin:  ");
		System.out.println("\t\t\t________________________");
		Userinput=input.next(); //Take UserInput
		errorcheckMethod();//call error check method to check if its only numbers
		//for loop for correct pin
		int pin = Integer.parseInt(Userinput);// declare a variable for a pin and change int to string
		for(int i=0;i<UseAcc.length;i++) {//for loop statement to keep the system loop
			//if statement to determine if correct
			if(pin == UseAcc[i].getUsersPin()) {
				index=i; //flag to get correct user
				//call/ option menu method
				optionMenu();
		    }//end if
		}//End For loop

		//for loop for incorrect pin
		for(int i=0;i<UseAcc.length;i++) {//account names.length =5
			//if statement to determine if incorrect> login again> 3 attempts
			if(pin !=UseAcc[i].getUsersPin()) {//if statement to determined incorrect pin
				System.out.println("Incorrect");
				AttemptsMethod();//if the the pin is incorrect attempt method will be called
				startATM();//the user will be asked to input the pin again
			}//end if
		}//end for loop
	}//end StartAtm Method
	
	
	public static  void optionMenu() {// this method will display the menu on the screen
		System.out.println("Welcome To The ATM : "+UseAcc[index].UsersName);
		System.out.println("");
		while (true) {// while loop will loop though the code if the condition is True
			System.out.println("\t\t|"+UseAcc[index].usersId+"\t\t"+UseAcc[index].UsersName+"\t\t"+UseAcc[index].UsersPin+"\t\t"+UseAcc[index].UsersBalance+"€|");//print out users details
			System.out.println("\t\t------------------------------------------------------");
			//ask the  user to choose from 1-3 option
			System.out.println("\t\t       PLEASE CHOOSE THE FOLLOWING OPTIONS: ");
			System.out.println("\t\t*******************************************************");
			System.out.println("1.Current Account");
			System.out.println("2.Saving Account");
			System.out.println("3.Exit");
			String choose = input.next();// take user input
			//switch statement to choose option
			switch(choose) {//Switch case to execute choose code
				case "1":
					CurrentAccount.CurrentAccountLogin(); break;// this will breaks out of the switch block
				case "2":
					SavingAccount.SavingAccountMenu(); break;
				case "3":
					logout();break;
				default:System.out.println ("ivalid option please enter eithet 1 or 2");// default to run code if there is no case match
				AttemptsMethod();// this method will give user 3 attempt the choose correct option 
			}//end switch case
		}//End While loop
	}//end option method
	 
	 public static  void Bankstatement() {// BANK statement
		//this method will display Users Bank statement on the screen
	 	System.out.println("Names:"+UseAcc[index].UsersName);
	 	System.out.println("Balance:"+UseAcc[index].UsersBalance+"€");
	 	System.out.println("pin:"+UseAcc[index].UsersPin);
	 }//end Bank Statement method
	
	public static  void logout() {// exit method
		System.out.println("THANKS FOR USING OUR SERVICE GOODBYE");
		System.exit(0);	
	}//end method
	
	protected static  void ChangePin() {//create method to change the pin
		//the user will be asked to enter the new pin
		System.out.println("Please enter your new pin: ");
		Userinput=input.next();//take user input
		errorcheckMethod();//check if the input is only number
	    int  pinchange=Integer.parseInt(Userinput);
		for(int i=0;i<UseAcc.length;i++) {//for loop statement to loop the user pin
			//if statement to match to the exit UserPASSWORD IF thats the case the attempt method will display
	    	if(pinchange == UseAcc[index].getUsersPin()){
			System.out.println("The Pin is already exit in our Database");//ask the user to input the new pin again
			AttemptsMethod();//call attempted if the user input old pin
			ChangePin();//call change pin method again  till no more attempt left
	    	}//end if
		}//end for
	    	    
		for(int i=0;i<UseAcc.length;i++) {//for loop statement to loop the user pin
			//if statement to get user new pin 
	    	if(pinchange != UseAcc[index].getUsersPin()){
	    		UseAcc[index].UsersPin=pinchange;
	    		System.out.println("Your New Pin is: "+  UseAcc[index].UsersPin);//ask the user to input the new pin again
	    		optionMenu();//call option menu
	    	}//end if
		}//end for loop
	}//end change pin Method
	
	public static  void AttemptsMethod() {// attempt methods
				counter--;//this will take one chance a time
				System.out.println("You have "+counter+" attempts left");//will display how many choice the user left
				//if statement to stop attempts
			if(counter==0) {//if statement to match the counter to 0 if thats the case system will end
				System.out.println("Goodbye");
				System.exit(0);//system exits
			}//end if	
	}//end method 
	
	public static  void errorcheckMethod() {//error check method
		while(!Userinput.matches("\\d+")) {//while loop the loop the user input
			System.out.println("ERROR,NUMBERS ONLY");//display on system
			counter--;
			System.out.println("You have "+counter+" attempts left");
			if (counter==0) {
				System.out.println("Goodbye");
				System.exit(0);//system will exit
			}//end if
			Userinput=input.next();//take user input again
		}//END while	
   }//end error check method
}//end class
