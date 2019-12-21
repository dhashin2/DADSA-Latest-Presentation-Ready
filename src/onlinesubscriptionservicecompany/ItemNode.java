package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class ItemNode { //Creating a node which only works with item instances
    
    private Item item; //Field for item
    private ItemNode nextItem; //Field that stores reference for the next node in the list
    
    public ItemNode(Item item){ //Constructor
        this.item = item;
    }
    // Getters and setters for items and next items
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemNode getNextItem() {
        return nextItem;
    }

    public void setNextItem(ItemNode next) {
        this.nextItem = next;
    }
    
    public void printItem(){ //Print item
        int iNumber = this.item.getItemNumberID();
        String iName = this.item.getItemName();
        int iStock = this.item.getItemStock();
        
        System.out.println("Item Number: " + iNumber + "| Item Name: " + iName + "| Quantity: " + iStock);
    }
    
}
