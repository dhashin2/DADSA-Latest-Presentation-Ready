package onlinesubscriptionservicecompany;

/**
 *
 * @author Dhashin
 */
public class Menu {
    static void menuHeader(){ //Print header
        
        System.out.println("-----------------------------");
        System.out.println("|    WELCOME TO OUR ONLINE  |");
        System.out.println("|    SUBSCRIPTION SERVICE   |");
        System.out.println("-----------------------------");
    }
    
    static void menuOptions(){ //Print instructions
       
        System.out.println("\nChoose your option:");
        System.out.println("(Type a number from 0-4)");
    }
    static void runMenu(){ //Print Menu
 
        System.out.println("\n1) View item list");
        System.out.println("2) View Transactions");
        System.out.println("3) View member list");
        System.out.println("4) Search for an item");
        System.out.println("5) Borrow an item");
        System.out.println("6) View borrowed items");
        System.out.println("7) Return borrowed item");
        System.out.println("8) Add member");
        System.out.println("9) Logout");
        System.out.println("0) Exit Program");
    }
    
}
