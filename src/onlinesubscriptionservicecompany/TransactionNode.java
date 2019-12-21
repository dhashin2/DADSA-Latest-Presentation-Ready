package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class TransactionNode { //Creating a node which only works with Transaction instances
    
    private Transaction transaction; //Field for transaction
    private TransactionNode nextTransaction; //Field that stores reference for the next node in the list

    public TransactionNode(Transaction transaction) {
        this.transaction = transaction;
    }
    //Getters and setters for transaction and nexttransaction
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public TransactionNode getNextTransaction() {
        return nextTransaction;
    }

    public void setNextTransaction(TransactionNode nextTransaction) {
        this.nextTransaction = nextTransaction;
    }
    
    public void printTransaction(){ //method to print transaction list
        // Objects which hold data from Transaction class fields
        int tItemID = this.transaction.getTransactionItemID();
        int tMemberID = this.transaction.getTransactionMemberID();
        String tDate = this.transaction.getDate();
        
        System.out.println("Item ID: " + tItemID + "| Member ID: " + tMemberID + "| Date: " + tDate);
    }
}
