package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class ItemLinkedList { //Item linked list to store all item information
    
    private ItemNode head; //The front of the linked list
    private int iSize; //To count how many items are in the linked list

    public ItemLinkedList(ItemNode head, int iSize) { //Constructor
        this.head = head;
        this.iSize = iSize;
    }

    public ItemLinkedList(){} //Empty constructor, auto generated
        
    public void addNodeItem(Item item){
        ItemNode iNode = new ItemNode(item); //Creating new item instance
        iNode.setNextItem(head); //Setting next item to insert to the front of the list
        head = iNode;
        iSize++;   
    }
    
    public int getiSize() { //Getter for getting size of list
        return this.iSize;
    }
    
    public void printItemList(){ //Method to print item list
        ItemNode currentNode = head; //Declaring a variable "currentNode" to store head data
        if(currentNode != null){ 
            while (currentNode != null){ //While loop which runs if currentNode(head) has data
            currentNode.printItem(); //Calling print method from ItemNode class to print data held in currentNode
            currentNode = currentNode.getNextItem(); //Getting next item from list after printing item in currentNode
            }
        } else {
            System.out.println("Nothing to see here"); //If there is no data in the list, print this
        }
    }

    public Item itemSearch(String iName){ //Searching itemlinkedlist for an item using its name
        for(ItemNode currentNode = head; currentNode != null;){ //loops when currentNode has a value
            Item userItem = (Item)currentNode.getItem(); //Useritem = name which user inputs
            if(userItem.getItemName().toLowerCase().equals(iName.toLowerCase())){ //If user input and item in the list are the same, return the item
                return userItem;
            }
            else{ //If user input and item are not the same, get next item in the list and repeat
            currentNode = currentNode.getNextItem();
            }
        }
        return null;
    }
}
