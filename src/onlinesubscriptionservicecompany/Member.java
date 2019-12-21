package onlinesubscriptionservicecompany;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dhashin
 */
public class Member { //Member class to classify all member information
    //Fields
    private int memberID;
    private String memberName;
    private String username;
    private int PIN;
    int itemLimit;
    Item[] borrowedItems;

    public Member(int memberID, String memberName, String username, int PIN) { //Constructor
        this.memberID = memberID;
        this.memberName = memberName;
        this.username = username;
        this.PIN = PIN;
        this.itemLimit = 5;
        this.borrowedItems = new Item[5];
    }

    Member(){} //Empty constructor, auto generated
    
    //All getter and setters for the item fields which have been declared in Member class
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getItemLimit() {
        return itemLimit;
    }

    public void setItemLimit(int itemLimit) {
        this.itemLimit = itemLimit;
    }

    public Item[] getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(Item[] borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    public Transaction borrowAndAddtoTrasactions(Item item){ //Method for a member borrow an item
        boolean duplicate = false; //Boolean to check if borrow itemlimit exceeds
        
        int index = 0; //Initialising and int value to go through the borrowed items array
        while(index < this.borrowedItems.length){ //While "index" is less than borrowed list, keep looping
            if(this.borrowedItems[index] != null){ //Checking if there is anything in the current index of the list
                //If the item in borrowed list and user requested item have the same properties
                if(this.borrowedItems[index].getItemName().toLowerCase().equals(item.getItemName().toLowerCase())){
                    //Print out that they cannot borrow the item twice
                    System.out.println("You cannot have 2 of the same item at the same time");
                    System.out.println("Please choose a different item to borrow");
                    duplicate = true; //Changing boolean to true because there is a duplicate item in the list
                    break;
                }
            }
        index++; //Increment int value for every iteration of the loop until condition is met
        }
        if(!duplicate){ //If the item that the user tries to borrow is not in their borrowed list, run the following code
            if(item.getItemStock() <= 0){
                System.out.println("Item is not available");
            }
            else if(itemLimit <= 5 && itemLimit > 0){ //If statement to set the maximum and minimum item limit for borrow list
                int index2 = 0; //Setting another int value to go throught the borrowed item list
                while(index2 < this.borrowedItems.length){ //While index2 value is less than borrowed list length, loop
                    if(this.borrowedItems[index2] == null){
                        
                        this.borrowedItems[index2] = item; //;Set that empty space to the item that user is trying to borrow
                        this.itemLimit--; //Decrement item limit
                        Transaction transaction = new Transaction(item.getItemNumberID(),this.memberID,getNewDate());
                        System.out.println("Item has successfully been borrowed"); 
                        item.print(); //Print item name and details from print function in item class
                        System.out.println(" ");
                        return transaction;
                    }
                index2++; //Increment index2 value for every iteration of loop until condition is met
                }
            }
            else{ //If the items that are already borrowed exceed 5 items, print the following only
                System.out.println("Sorry, you have reached the maximum borrow limit of 5");
                System.out.println("Please return an item or try again after an item has expired");
            }
        }
        return null;
    }
    
    public void returnItem(Member user){ //Method to return a borrowed item
        boolean noBorrowedItems = true; //Setting a boolean value to true in order to check if there are any items in the borrowed list
        
        int i = 0;
        while(i < this.borrowedItems.length){ //While loop to check if there are any items in the list
            if(this.borrowedItems[i] != null){
                noBorrowedItems = false; //If list is not empty, set value to false as there are borrowed items in the list
                break;
            }
        i++;
        }
        
        if(!noBorrowedItems){ //If there are borrowed items in the list
            boolean returned = false; //Set boolean value to false in order to check if item has been returned or not
            Scanner sc = new Scanner(System.in); //Initialise scanner for user input
            System.out.println("\nEnter item you would like to return");
            String name = sc.nextLine(); //Scan user input
            
            int n = 0;
            while(n < this.borrowedItems.length){ //Looping through item list to see if we can find a match for users input
                if(this.borrowedItems[n] != null){ //If we get a match;
                    if(this.borrowedItems[n].getItemName().toLowerCase().equals(name.toLowerCase())){
                        this.borrowedItems[n] = null; //;Set that node to null (remove the item from list);
                        System.out.println("\nItem has successfully been returned");
                        this.itemLimit++; //Increment the max item limit for that user
                        returned = true; //Set returned value to true since item has been returned
                        break;
                    }
                }
            i++;
            }
            if(!returned){ //If item has not been returned, it means the item is not in the list
                System.out.println("\nYou do not have that item in your borrowed list");
            }
        } else { //And if the list is empty, print this
            System.out.println("\nNothing to see here");
        }   
    }
    
    public String getNewDate(){ //Method to get todays date for transactions
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");  
        Date date = new Date();  
        formatter.format(date); 
        return formatter.format(date);
    }
    
    public void printBorrowedItems(){ //Print borrowed item list
        if(itemLimit != 5){
            int i = 0;
            while(i < this.borrowedItems.length){
                if(this.borrowedItems[i] != null){
                    Item item = this.borrowedItems[i];
                    System.out.format("Item ID: " + item.getItemNumberID() + " |Item Name: " + item.getItemName());
                    System.out.println(); 
                }
            i++;
            }
        } else {
            System.out.println("No items have been borrowed\n");
        }
    }
}