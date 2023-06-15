package CollageApp;
   
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CollageAPP  {
	// create  local variable
	public static String Letters;
	public static String Userinput;
	
  public CollageAPP(int id, String name, int age, String email) {
		super();//the constructor indicates that the constructor of the superclass such like the class that CollageAPP inherits from. 
		
	}

  private static ArrayList<Student> students=new ArrayList<>();// arraylist to store student data
  static Scanner Scanner = new  Scanner(System.in);// create scanner object for the userinput
 public static void main(String[] args) {//start main method

      optionMenu();// option method being called
 }//end main method

 public static void optionMenu() {// this method will display the menu on the screen
    System.out.println("Welcome To The Collage : ");
    System.out.println("");
    Scanner scanner = new Scanner(System.in); // initialize the scanner variable
    while (true) {// while loop will loop though the code if the condition is True
     
  	    System.out.println("\t\t*******************************************************");
			//ask the  user to choose from 1-8 option
			System.out.println("\t\t       PLEASE CHOOSE THE FOLLOWING OPTIONS: ");
			System.out.println("\t\t*******************************************************");
			System.out.println("1.Show all full time student");
			System.out.println("2.Show all Mature Student");
			System.out.println("3.Add new Full time Student");
			System.out.println("4.Add new Mature student");
			System.out.println("5.Remove student");
			System.out.println("6.View All student Alphabetically");
			System.out.println("7.Print Out Student List to the text File");
			System.out.println("8.Exit");
			String choose = scanner.next();// take user input
		
			//switch statement to choose option
			switch(choose) {//Switch case to execute choose code
				case "1":
					Showallfulltimestudent(); 
					break;// this will breaks out of the switch block
				case "2":
					ShowallMaturestudent(); 
					break;
				case "3":
					AddnewFulltimeStudent();
					break;
				case "4":
					AddnewMaturestudent();
					break;
				case "5":
					RemoveStudent();
					break;
				case "6":
					viewAllStudentsAlphabetically();
					break;
				case "7":
					PrintOutStudentsList();
					break;
				case "8":
					Exit();
					break;

				default:System.out.println ("ivalid option please enter  1 up to 8");// default to run code if there is no case match
				optionMenu();// call optionmenue
			}//end switch case
		}//End While loo
 }//end method
 public static void Showallfulltimestudent() {// create method to show fulltime student list
     for (Student student : students) {// for-each loop to iterate over each Student object in the students array.
             System.out.println(student);//print the list
         }//end for
     }//end method

 public static void ShowallMaturestudent() {// create method to show mature student list
	    for (Student student : students) {// for-each loop to iterate over each Student object in the students array.
	        if (student instanceof MatureStudent) {//if statment to check if the object referenced by the variable student is an instance of the class MatureStudent.
	            System.out.println(student);//print mature student list
	        }else { 
	        	System.out.println("No mature students found.");// 
	        }//end else
	    }//end for
	}//end method


 public static void AddnewFulltimeStudent() {//create method to add new fulltime student
    System.out.print("Enter student ID: ");//ask the user their id
    Userinput= Scanner.next();//take input
    errorcheckMethod();//check if the user inpute correct value
    int id = Integer.parseInt(Userinput);//  convert a String variable Userinput into an integer value id.
    for (Student student : students) {// for-each loop to iterate over each Student object in the students array.
        if (student.getId() == id) {// if statment check the  user id exit in the database
            System.out.println("we have same id number in the database please choose differnt ID.");
            return;
        }//end if
    }//end for
    System.out.print("Enter student Name: ");//ask the user name
    Letters = Scanner.next();//take user input
    Checkinput();//check if the user input only latters
    String name = String.valueOf(Letters);// convert String Letter of values to String name.
    System.out.print("Enter student Email: ");//ask the user email
    String email = Scanner.next();//user input
    while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {//while loop to loop the user input
        System.out.println("Please input a valid email:");//ask the user for valid email
        email = Scanner.next();
    }//end while
    students.add(new FulltimeStudent(id, name , email ));//add the student data to the array list
    System.out.println("Full-time Student added!");
 }//end addnewfulltime student method


 private static void AddnewMaturestudent() {//create method to add mature student
    System.out.println("Enter mature student id:");//ask the user input id
    Userinput= Scanner.next();//take user input
    errorcheckMethod();//method to cheak if the user input correct value
    int id = Integer.parseInt(Userinput);// convert a String variable Userinput into an integer value id.
    for (Student student : students) {// for-each loop to iterate over each Student object in the students array.
            if (student.getId() == id) {// check the  user id exit in the database
                System.out.println("we have same id number in the database please choose differnt ID");
                return;//return to the menu
            }//end if
	}//end for
	System.out.println("Enter mature student name:");//ask the user input name
	Letters = Scanner.next();//take user input
	Checkinput(); //check if the user input only latters
	String name = String.valueOf(Letters);// convert String Letter of values to String name.
	System.out.println("Enter mature student age:");//ask the userinput age
	Userinput= Scanner.next();//take user input
	errorcheckMethod();//method to cheak if the user input correct value
    int age = Integer.parseInt(Userinput);// convert a String variable Userinput into an integer value id.

	    if (age < 23) {//if statemt to check if the user is over 23 years of age
	      System.out.print("Error: You must be at least 23 years old Please Try Again.");
	      System.out.println("\t\t");
	     return;//return to the menu
	    		 
	    }else {//else statment to continue if the user is over 23 age
	    		
	    Scanner.nextLine(); // consume newline character
	    System.out.println("Enter mature student email:");;
	    String email = Scanner.next();
	    while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {//while loop to loop the user input
	        System.out.println("Please input a valid email:");//ask the user for valid email
	        email = Scanner.next();//take user input
	    }//end while
	    students.add(new MatureStudent(id, name ,age, email ));//add the student data to the array list
	    System.out.println("New mature student added.");

	    }//end else
 }// end method   		

 public static void RemoveStudent() {//creat method to remove student
    System.out.print("Enter student ID: ");//ask the user to input id
    Userinput= Scanner.next();//user input
    errorcheckMethod();//method to cheak if the user input correct value
    int id = Integer.parseInt(Userinput);// convert a String variable Userinput into an integer value id.
    for (Student student : students) {// for-each loop to iterate over each Student object in the students array.
        if (student.getId() == id) {// check the  user id exit in the database
            students.remove(student);//if it exits it will remove the student from the database
            System.out.println("Student removed!");
            return;//return to the menu
        }else {//else statement to show a message if the student not found 
        	System.out.println("Student not found.");
        }// end else
    }//end for
 }//end method

 public static void viewAllStudentsAlphabetically() {//create method to show student list alphabetically
	//method to sort the list of students alphabetically by their name, using a lambda expression with the Comparator.comparing() method.
    Collections.sort(students, Comparator.comparing(Student::getName));
    students.forEach(System.out::println);//print using four dot syntax
 }//end method

 public static void PrintOutStudentsList() {//create mehod to print the student list on the file
    try {//try statemt 
        FileWriter writer = new FileWriter("studentList");//create new filewriter object 
        writer.write("Students table\n");/*writes the string "Students table" followed by a newline character to a file or output stream 
                                           using the write() method of the writer object.*/
        for (Student student : students) {// for-each loop to iterate over each Student object in the students array.
            writer.write(student.toString() + "\n");//output stream using the write() method of the writer object
        }
        writer.close();//File is automatically closed when the with block ends
        System.out.println("Student list printed to file succefully!");
    } catch (IOException e) {//this will catch errors during printstudentlist() method being excuted
        System.out.println("Error coding to file.");
    }//end catch
 }//end method
 private static void Exit() {//craete method to close the system
    System.out.println("Thanks for using our service Good bye!");//	
    System.exit(0);//system will end
 }//end method

 public static  void errorcheckMethod() {//error check method
	while(!Userinput.matches("\\d+")) {//while loop the loop the user input
		System.out.println("please Numbers only");//
		Userinput = Scanner.next();//take the user input again
	}//end while
 }//end method	

 public static void Checkinput(){//craete method to check if the user input only letters
    while(!Letters.matches("[a-zA-Z]{1,15}")){//while statment to detect if user input valid charcter for email
        System.out.println("Only letters to enter, please try again! ");
        Letters = Scanner.next();
    }//end while
 }//end method
 /*public static void emailvalidation() {//error check method
	  String email = Scanner.next();
	  while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {//while loop to loop the user input
	        System.out.println("Please input a valid email:");//ask the user for valid email
	        email = Scanner.next();
	    }
	}*/	
 
}//end class
