package onlinesubscriptionservicecompany;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Dhashin
 */
public class CSVReader {
    //Item file reader
    public static ItemLinkedList itemFileReader(){
        ItemLinkedList iList = new ItemLinkedList();
	String csvFile = "item.csv"; //Csv file location
	String line = ""; 
	String splitBy = ","; //Splitting the lines with commas
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {     
                    br.readLine(); //readLine used to read first line before while loop since its the header line in the csv
                    //While loop to read each line until there are no more lines in the file
                    while ((line = br.readLine()) != null) { //Readline function is used to read a line from the file
                    String[] itemDetails = line.split(splitBy); //Split function is used to split the words in the line by commas
                    Item item = new Item(Integer.parseInt(itemDetails[0]),itemDetails[1],Integer.parseInt(itemDetails[2])); //Adding the data into Item
                    iList.addNodeItem(item);
                    }
                    return iList;
		}  
                catch (IOException e) {
		    System.out.println("Error" + e); //Catch and Print the error
		}
        return iList;
    }
    //Replicated file reader used for itemFileReader
    public static MemberLinkedList memberFileReader(){ 
        MemberLinkedList mList = new MemberLinkedList();
	String csvFile = "member.csv";
	String line = ""; 
	String splitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    br.readLine(); 
                    while ((line = br.readLine()) != null) { 
                    String[] memberDetails = line.split(splitBy);
                    Member member = new Member(Integer.parseInt(memberDetails[0]), memberDetails[1], memberDetails[2], Integer.parseInt(memberDetails[3]));
                    mList.addNodeMember(member);
                    }
                    return mList;
		}  
                catch (IOException e) {
		    System.out.println("Error" + e);
		}
        return mList;
    }
    //Tweaked item file reader by adding date format in order to read date from transaction csv
    public static TransactionLinkedList transactionFileReader() throws ParseException{
        TransactionLinkedList tList = new TransactionLinkedList();
	String csvFile = "transaction.csv";
	String line = ""; 
	String splitBy = ",";
        
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    br.readLine(); 
                    while ((line = br.readLine()) != null) { 
                    String[] transactionDetails = line.split(splitBy);
                    Transaction transaction = new Transaction(Integer.parseInt(transactionDetails[0]),Integer.parseInt(transactionDetails[1]),transactionDetails[2]);
                    tList.addNodeTransaction(transaction);
                    }
                    return tList;
		}  
                catch (IOException e) {
		    System.out.println("Error" + e);
		}
        return tList;
        
    }
}
