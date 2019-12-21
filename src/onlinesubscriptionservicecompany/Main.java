package onlinesubscriptionservicecompany;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dhashin
 */
public class Main {

    public static Clerk clerk = new Clerk(); //Initialising clerk class, in order to use its methods
    public static Member user = new Member();
    public static boolean loginSuccessful = false;
    
    public static void main(String[] args) throws ParseException {
        clerk.fileReader(); //Reading all csv files at start of program
        System.out.println("\nCREDENTIALS ARE CASE SENSITIVE\n");
        
        login(); //Calling login function
         
        if(loginSuccessful){ //If login is successful, display and run the program
        program(); //Calling program function    
        }
    }
    
    public static void login(){
        do{ //Do this while loginSuccessful == false
            try{
                String username; //String variable to store username
                int PIN; //Int variable to store PIN number
                
                Scanner loginDetails = new Scanner(System.in); //Initialising scanner to scan user input for login details
                
                System.out.println("Please enter your Username: ");
                username = loginDetails.nextLine(); //Scanning user input for username
                
                System.out.println("Please enter your PIN code: ");
                PIN = loginDetails.nextInt(); //Scanning user input for PIN number
                
                loginDetails.nextLine(); //Clear input buffer
                
                user = clerk.searchMember(username, PIN); //Checking if input values match any members from the memberlinkedlist
                if(user == null){ //If there is no user with said credentials, print invalid
                    System.out.println("\nCREDENTIALS ARE NOT VALID\n");
                }
                else{ //If there is a user with said credentials, then they have logged in, so loginSuccessful = true
                    loginSuccessful = true;
                }
            }
            catch(InputMismatchException e){ //InputMismatchException for printing an error report if the user types invalid input for PIN number
                System.out.println("\nError: PIN IS A NUMBER, NO OTHER CHARACTERS\n");
            }   
        }while(!loginSuccessful);
    }
    
    public static void program(){
        boolean terminate = false; //Declaring a boolean value for case "0" which exits the program
        Menu.menuHeader(); //Printing menu header outside while loop because we don't want to loop the header every iteration
        Menu.menuOptions(); //Printing menu options only once, we don't want to repeat this every iteration

        while(!terminate){
            Menu.runMenu(); //running our menu outline via Menu class
            String option; //Creating a string variable to store options that the user takes
            Scanner scanOption = new Scanner(System.in); //Making scanner to scan user inputs for all cases
            option = scanOption.next(); //Storing value in the string variable via scanner
            scanOption.nextLine();
            
            switch(option){ //Switch case for user options
                
            case "0": //Case for exiting the program
                terminate = true; //this exits the program
                clerk.memberFileWriter();
                clerk.transactionFileWriter();
                System.out.println("Thanks for using our application, see you next time!"); //Message to user
                break;
                
            case "1": //Case for showing item list
                clerk.printItemList();
                break;
                
            case "2": //Case for showing list of transactions that have been made
                clerk.printTransactionList();
                break;
                
            case "3": //Case for showing list of members and their ID
                clerk.printMemberList();
                break;   
                
            case "4": //Case for searching items from itemlinkedlist using item name
                System.out.print("\nSearch for item: ");
                String iName = scanOption.nextLine(); //Scanning next line for user input
                Item searchForItem; //Creating a new item instance "searchForItem"
                searchForItem = clerk.searchItem(iName); //using search method in clerk class to assign item name to variable "searchForItem"

                    if(searchForItem != null){ //If the item is in the list, print item name
                        System.out.println("\nITEM IS IN OUR DATABASE\n");
                        searchForItem.print();
                        System.out.println();
                    }
                    else{ //If not, then print that it is not available
                        System.out.println("\nITEM IS NOT IN OUR DATABASE");
                    }
                break;
                    
            case "5": //Case for the user to borrow an item from the list
                System.out.println("Enter the item you would like to borrow\n");
                clerk.borrowItem(user);
                break;
            
            case "6": //Show all borrowed items for that member
                System.out.println("You have borrowed the following items");
                user.printBorrowedItems();
                scanOption.nextLine();
                break;
            
            case "7": // Return item from borrowed list
                user.returnItem(user);
                scanOption.nextLine();
                break;
                
            case "8": //Add Member
                clerk.addMember();
                break;
              
            case "9": //Logout
                String yes = "yes";
                String no = "no";
                String userInput;
                System.out.println("\nAre you sure you would like to logout?");
                System.out.println("Type 'yes' or 'no'");
                userInput = scanOption.nextLine();
                if(userInput.equals(yes)){
                    System.out.println("\nLogout Successful\n");
                    login();
                }
                else if(userInput.equals(no)){
                    System.out.println("\nYou have declined logout");
                }
                else{
                    System.out.println("\nPlease type appropriate command");
                }
            }
        }
    }
}
