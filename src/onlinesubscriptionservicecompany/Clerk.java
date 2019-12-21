package onlinesubscriptionservicecompany;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dhashin
 */
public class Clerk { //Clerk class controls login, item search, member search and reading all csv files
    //Creating list class instances in order to add data into declared variables
    private ItemLinkedList iList;
    private MemberLinkedList mList;
    private TransactionLinkedList tList;
    
    public Clerk(){} //Empty constructor, auto generated
        
    public void fileReader() throws ParseException{ //Reading all the csv files, later used to call to main class
        this.iList = CSVReader.itemFileReader();
        this.mList = CSVReader.memberFileReader();
        this.tList = CSVReader.transactionFileReader();
    }
    
    public void memberFileWriter(){ //Method to write back to file with new information
        try{
            File file = new File("member.csv"); //Setting which file to write to
            //Declaring string values for writing back header of csv
            String ID = "Member_ID";
            String Name = "Member Name";
            String username = "Member Username";
            String PIN = "Member PIN";
            FileWriter writer = new FileWriter(file); //Making new file writer instance
            writer.write(ID + "," + Name + "," + username + "," + PIN); //Write header line before going into loop
            writer.write("\r\n"); //write in new line afterwriting header
            for(int i = 0; i < this.mList.getmSize(); i++){ //For loop which runs until size of list is covered
                Member member = this.mList.getAnyMember(i); //Writing over members until all members are written
                writer.write(member.getMemberID() + "," + member.getMemberName() + "," + member.getUsername() + "," + member.getPIN()); //Format to write with
                writer.write("\r\n"); //Write in new line always
            }
            writer.close(); //Close writer
        } catch(Exception e){ //Catching error incase there is a bug
            System.out.println("File Writer error");
        }
    }
    
    public void transactionFileWriter(){ //Method to write back to file with new information
        try{
            File file = new File("transaction.csv"); //Setting which file to write to
            //Declaring string values for writing back header of csv
            String ItemID = "Item_ID";
            String MemberID = "Member_ID";
            String newDate = "Date";
            
            FileWriter writer = new FileWriter(file); //Making new file writer instance
            writer.write(ItemID + "," + MemberID + "," + newDate); //Write header line before going into loop
            writer.write("\r\n"); //write in new line afterwriting header
            for(int i = 0; i < this.tList.gettSize(); i++){ //For loop which runs until size of list is covered
                
                Transaction transaction = this.tList.getAnyTransaction(i); //Writing over members until all members are written
                
                writer.write(transaction.getTransactionItemID()+ "," + transaction.getTransactionMemberID() + "," + transaction.getDate()); //Format to write with
                writer.write("\r\n"); //Write in new line always
            }
            writer.close(); //Close writer
        } catch(Exception e){ //Catching error incase there is a bug
            System.out.println("File Writer error" + e);
        }
    }
    
    public void printMemberList(){ //Method to print item list, called from itemlinkedlist class
        this.mList.printMemberList();
    }
    
    public void printItemList(){ //Method to print item list, called from itemlinkedlist class
        this.iList.printItemList();
    }
    
    public void printTransactionList(){ //Method to print transaction list, called from transactionlinkedlist class
        this.tList.printTransactionList();
    }
    
    public Item searchItem(String iName){ //Method to search for name of items inside itemlinkedlist
        return this.iList.itemSearch(iName);
    }
    
    public Member searchMember(String username, int PIN){ //Method to search for member usernamename and password for login
        return this.mList.memberSearch(username, PIN);
    }
    
    public void generateMemberID(){ //Method to generate a memberID when creating new member
        this.mList.newMemberID();
    }
    
    public void borrowItem(Member member){ //Method for member to book item from the item list
        Scanner scan = new Scanner(System.in); //Init scanner
        String itemName; //Empty string to store user input item name
        itemName = scan.nextLine(); //Scan next line for user input
        Item itemToBorrow;  //Creating new item instance which holds item to borrow
        itemToBorrow = this.iList.itemSearch(itemName); //Search for item names through item linked list and assign to itemtoborrow
        //If statement for when item to borrow is not null, decrement the item stock/quantity and add to new transaction instance
        if(itemToBorrow != null){
            itemToBorrow.decrementItemStock();
            Transaction transaction;
            transaction = member.borrowAndAddtoTrasactions(itemToBorrow);
            if(transaction != null){ //If transaction has a value inside, push that value into the node list
                this.tList.addNodeTransaction(transaction);
            }
        } else { //If itemtoborrow has found no value, then the item is not in the list
            System.out.println("Item not found or is unavailable");
        }
    }
    
    public void addMember(){ //Method to add member to list of members
        try{
            Scanner userInput = new Scanner(System.in); //Initialise Scanner to scan user input
            int ID; //Int variable for member ID
            int PIN; //Int variable for member PIN code
            String username;
            String memberName;
            boolean valid = true;
            
            System.out.println("\nType Member Name");
            memberName = userInput.nextLine(); //Scanning user input for Member name
            
            System.out.println("Type Username");
            username = userInput.nextLine(); //Scanning user input for username of member
            
            ID = this.mList.newMemberID() + 1; //Generated member id from memberID_Generator class
            for(int i = 0; i < this.mList.getmSize(); i++){
                if(username.equals(this.mList.getAnyMember(i).getUsername())){
                    System.out.println("Username is already taken");
                    valid = false;
                }
            }
            if(valid){
            System.out.println("Type PIN number");
            PIN = userInput.nextInt(); //Scanning user input integer value to assign PIN number to member
            userInput.nextLine();
            //Converting the integer values to a string to put in a String array
            String memberID = Integer.toString(ID); 
            String memberPIN = Integer.toString(PIN);
            //String array to hold member details before we add to linked list
            String [] memberDetails = new String []{memberID,memberName,username,memberPIN};
            Member member;
            //Putting all member information to Member class instance "member"
            member = new Member((Integer.parseInt(memberDetails[0])), memberDetails[1], memberDetails[2],Integer.parseInt(memberDetails[3]));
            mList.addNodeMember(member); //Add member details to member linked list using node
            }
        }
        catch(InputMismatchException e){
            System.out.println("\nPIN NUMBER SHOULD BE AN INTEGER VALUE");
            System.out.println("              TRY AGAIN");
        }
    }
}
