package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class Transaction { //Transaction class to classify all transaction information
    //Fields
    private int transactionItemID;
    private int transactionMemberID;
    private String date;

    public Transaction(int transactionItemID, int transactionMemberID, String date) { //Constructors for all field
        this.transactionItemID = transactionItemID;
        this.transactionMemberID = transactionMemberID;
        this.date = date;
    }
    
    //All getter and setters for the three item fields which have been declared in Transaction class
    public int getTransactionItemID() {
        return transactionItemID;
    }

    public void setTransactionItemID(int transactionItemID) {
        this.transactionItemID = transactionItemID;
    }

    public int getTransactionMemberID() {
        return transactionMemberID;
    }

    public void setTransactionMemberID(int transactionMemberID) {
        this.transactionMemberID = transactionMemberID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
}
