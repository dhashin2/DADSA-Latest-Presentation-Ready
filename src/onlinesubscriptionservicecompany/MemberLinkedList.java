package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class MemberLinkedList { //Member linkedlist which holds member information
    
    private MemberNode head; //The front of the linked list
    private int mSize; //To count how many items are in the linked list

    public MemberLinkedList(MemberNode head, int mSize) { //Constructor
        this.head = head;
        this.mSize = mSize;
    }

    public MemberLinkedList() { //Empty constructor, auto generated
        
    }
    
    public void addNodeMember(Member member){ //Method to add members to the linked list
        MemberNode mNode = new MemberNode(member); //Creating new item instance
        mNode.setNextMember(head); //Setting next item to insert to the front of the list
        head = mNode;
        mSize++;    
    }
    
    public void getMember(){
        
    }
    
    public Member memberSearch (String username, int PIN){ //Searching memberlinkedlist for a member using their name and id
        for(MemberNode currentNode = head; currentNode != null;){ //loops when currentNode has a value
            if(currentNode.getMember().getUsername().equals(username) && (PIN == currentNode.getMember().getPIN())){     
                return currentNode.getMember(); //If username and pin in list match that of user input return member
            }
            else{ //If they do not match, go to the next member
            currentNode = currentNode.getNextMember();
            }
        }
        return null;
    }
    

    public int getmSize() { //Getter for getting size of list
        return this.mSize;
    }
    
    public void printMemberList(){ //Method to print item list
        MemberNode currentNode = head; //Declaring a variable "currentNode" to store head data
        if(currentNode != null){ 
            while (currentNode != null){ //While loop which runs if currentNode(head) has data
            currentNode.printMember(); //Calling print method from ItemNode class to print data held in currentNode
            currentNode = currentNode.getNextMember(); //Getting next item from list after printing item in currentNode
            }
        } else {
            System.out.println("Nothing to see here"); //If there is no data in the list, print this
        }
    }
    
    public Member getAnyMember(int n){ //Method to grab any member from member linked list
        MemberNode currentNode = head; 
        int count; //Counter to count the nodes in the linked list
        count = 0; //Setting count to 0
        if(count != n){ //If count is not equal to n value, keep searching the list using while loop
            while(count != n){
                currentNode = currentNode.getNextMember(); //Get next member until count is equal to n 
                count++; //Increment count
            }
        }
        else{ //Get member if count is equal to n
            return currentNode.getMember();  
        }
        return currentNode.getMember(); //Return member in the n'th node
    }
    
    public int newMemberID(){ //Method to generate ID number for new members
        int checkID; //Declaring int to check and hold current largest ID
        checkID = this.getAnyMember(0).getMemberID(); //Checking IDs from the start of the list, therefore index is 0
        int check = 0; //Initialising int to check member IDs
        while(check > this.getmSize()){ //While loop to get largest ID
            //Getting member ID of members and storing in check, and seeing if its greater than largest ID
            if(checkID < this.getAnyMember(check).getMemberID()){ //If value of check is greater than checkID;
                checkID = this.getAnyMember(check).getMemberID(); //; Make checkID equal to check
                check++; //Keep incrementing check until list is empty
            }
        }
        return checkID; //Return checkID which now has the current largest member ID from the list
    }
}

