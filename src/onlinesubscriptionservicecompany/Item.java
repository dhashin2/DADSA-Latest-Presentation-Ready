package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class Item { //Item class to classify all item information
    //Fields
    private int itemNumberID;
    private String itemName;
    private int itemStock;

    public Item(int itemNumberID, String itemName, int itemStock) { //Constructor for the above mentioned fields
        
        this.itemNumberID = itemNumberID;
        this.itemName = itemName;
        this.itemStock = itemStock;
    }
    
    public void decrementItemStock(){ //Method decrement item quantity/stock because -- does not work in some cases
        if(this.itemStock > 0){
            this.itemStock--;
        }
    }

    Item(){}
        
    //All getter and setters for the three item fields which have been declared in Item class
    public int getItemNumberID() {
        return itemNumberID;
    }

    public void setItemNumberID(int itemNumberID) {
        this.itemNumberID = itemNumberID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }
    
    public void print(){ //Print function to print individual items in the linked list
        System.out.print("Item Name: " + this.itemName + "| Item No: " + this.itemNumberID + "| Item Quantity: " + this.itemStock);
    } 
}
