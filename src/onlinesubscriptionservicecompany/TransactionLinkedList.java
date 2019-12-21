package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class TransactionLinkedList { //Transaction linked list to store all transaction information
    
    private TransactionNode head; //The front of the linked list
    private int tSize; //To count how many transactions are in the linked list

    public TransactionLinkedList(TransactionNode head, int tSize) { //Constructor
        this.head = head;
        this.tSize = tSize;
    }

    public TransactionLinkedList() { //Constructor
        
    }
    
    public void addNodeTransaction(Transaction transaction){ //Method to add item to transaction list
        TransactionNode tNode = new TransactionNode(transaction); //Creating new transaction instance
        tNode.setNextTransaction(head); //Setting next transaction to insert to the front of the list
        head = tNode;
        tSize++;
        
    }
    
    public Transaction getAnyTransaction(int n){ //Method to grab any member from member linked list
        TransactionNode currentNode = head; 
        int count; //Counter to count the nodes in the linked list
        count = 0; //Setting count to 0
        if(count != n){ //If count is not equal to n value, keep searching the list using while loop
            while(count != n){
                currentNode = currentNode.getNextTransaction(); //Get next member until count is equal to n 
                count++; //Increment count
            }
        }
        else{ //Get member if count is equal to n
            return currentNode.getTransaction();  
        }
        return currentNode.getTransaction(); //Return member in the n'th node
    }

    public int gettSize() { //Getter for getting size of list
        return this.tSize;
    }
    
    public void printTransactionList(){ //Method to print transaction list
        TransactionNode currentNode  = head; //Declaring a variable "currentNode" to store head data
        if(currentNode != null){ 
            while (currentNode != null){ //While loop which runs if currentNode(head) has data
            currentNode.printTransaction(); //Calling print method from TransactionNode class to print data held in currentNode
            currentNode = currentNode.getNextTransaction(); //Getting next Transaction from list after printing Transaction values in currentNode
            }
        } else {
            System.out.println("Nothing to see here"); //If there is no data in the list, print this
        }
    }
}
